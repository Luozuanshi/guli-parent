<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" controls-position="right" min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level" clearable placeholder="请选择">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
          -->
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career"/>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像：TODO -->

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import teacher from "@/api/teacher";
export default {
  data() {
    return {
      id: "",
      teacher: {},
      saveBtnDisabled: false
    };
  },
  created() {this.init()},
  watch: {
    $route(to, from) {
        console.log("路由发生变化")
        this.init()
        }
  },
  methods: {
    init() {
      //如果 路由url中带有id回显讲师信息
      if (this.$route.params.id) {
        this.id = this.$route.params.id;
        console.log(this.id);
        teacher.getById(this.id).then(res => {
          this.teacher = res.data.item;
        });
      } else {
        //新增讲师 情况teacher信息
        this.teacher = {};
      }
    },
    saveOrUpdate() {
      console.log(this.teacher.id);
      if (this.teacher.id) {
        console.log("修改");

        this.updateTeacher();
      } else {
        this.saveTeacher();
      }
    },
    //新增讲师
    saveTeacher() {
      teacher.saveData(this.teacher).then(res => {
        this.$message({
          type: "success",
          message: "添加成功!"
        });
      });
      // 跳转页面
      this.$router.push({ path: "/teacher/list" });
    },
    //更新讲师
    updateTeacher() {
      teacher.updateData(this.teacher).then(res => {
        this.$message({
          type: "success",
          message: "修改成功!"
        });
      });
      // 跳转页面
      this.$router.push({ path: "/teacher/list" });
    }
  }
};
</script>
