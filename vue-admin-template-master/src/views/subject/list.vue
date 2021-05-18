<template>
  <div class="app-container">
    <el-input v-model="filterText" placeholder="Filter keyword" style="margin-bottom:30px;" />

    <el-tree
      ref="subjectTree"
      :data="subjectList"
      :props="defaultProps"
      :filter-node-method="filterNode"
      class="filter-tree"
      default-expand-all
    />

  </div>
</template>
<script>
import subject from "@/api/subject";
export default {
  data() {
    return {
      filterText: "",
      subjectList: [],
      defaultProps: {
        children: "children",
        label: "title"
      }
    };
  },
  created() {
    this.fetchNodeList();
  },
  methods: {
    fetchNodeList() {
      subject.getAllSubject().then(res => {
        if (res.success === true) {
          this.subjectList = res.data.allSubject;
        }
      });
    },

    filterNode(value, data) {
      if (!value) return true;
      return data.title.indexOf(value) !== -1;
    }
  },
  watch: {
    filterText(val,old) {
        console.log(val)
        this.$refs.subjectTree.filter(val)
    }
  }
};
</script>
