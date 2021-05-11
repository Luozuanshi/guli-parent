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
  //删除讲师
  removeById(id) {
    return request({
      url: `/eduservice/teacher/${id}`,
      method: 'delete'
    })
  }

}
