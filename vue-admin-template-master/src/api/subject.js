import request from '@/utils/request'

export default {
  //   获取代条件的讲师列表
  getAllSubject() {
    return request({
      url: `/eduservice/subject`,
      method: 'get'
    })
  }
}
