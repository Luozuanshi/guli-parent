import request from '@/utils/request'

export default {

  //   获取代条件的讲师列表
  pageList(pageNo, limit, teacherQuery) {
    return request({
      url: `/eduservice/teacher/${pageNo}/${limit}`,
      method: 'post',
      data: teacherQuery // json格式传输
    })
  },
  // 删除讲师
  removeById(id) {
    return request({
      url: `/eduservice/teacher/${id}`,
      method: 'delete'
    })
  },
  // 新增讲师
  saveData(teacher) {
    return request({
      url: `/eduservice/teacher`,
      method: 'post',
      data: teacher // json格式传输
    })
  },
  // 根据id查询讲师
  getById(id) {
    return request({
      url: `/eduservice/teacher/${id}`,
      method: 'get'
    })
  },
  // 修改讲师
  updateData(teacher) {
    return request({
      url: `/eduservice/teacher`,
      method: 'put',
      data: teacher // json格式传输
    })
  },
  // 获取讲师列表
  getTeacherList() {
    return request({
      url: `/eduservice/teacher`,
      method: 'get'
    })
  }

}
