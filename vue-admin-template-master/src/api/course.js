import request from '@/utils/request'

export default {
  //   获取代条件的讲师列表
  saveCourseInfo(courseInfoForm) {
    return request({
      url: `/eduservice/course/saveCourseInfo`,
      method: 'post',
      data:courseInfoForm
    })
  }
}
