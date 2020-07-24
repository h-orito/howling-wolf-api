package com.ort.howlingwolf.fw.interceptor

import com.ort.howlingwolf.fw.HowlingWolfDateUtil
import com.ort.howlingwolf.fw.HowlingWolfUserInfoUtil
import com.ort.howlingwolf.fw.security.HowlingWolfUser
import org.dbflute.hook.AccessContext
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class HowlingWolfAccessContextInterceptor : HandlerInterceptorAdapter() {

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        // [アクセス日時]
        val accessLocalDateTime = HowlingWolfDateUtil.currentLocalDateTime()

        // [アクセスユーザ]
        val userInfo: HowlingWolfUser? = HowlingWolfUserInfoUtil.getUserInfo()
        val accessUser = userInfo?.username ?: "not_login_user"
        val ipAddress = request.remoteAddr

        val context = AccessContext()
        context.accessLocalDateTime = accessLocalDateTime
        context.accessUser = "$accessUser: $ipAddress"
        AccessContext.setAccessContextOnThread(context)

        // Handlerメソッドを呼び出す場合はtrueを返却する
        return true
    }
}