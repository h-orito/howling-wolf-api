package com.ort.wolf4busy.fw.interceptor

import com.ort.wolf4busy.fw.Wolf4busyDateUtil
import com.ort.wolf4busy.fw.Wolf4busyUserInfoUtil
import org.dbflute.hook.AccessContext
import org.springframework.lang.Nullable
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class Wolf4busyAccessContextInterceptor : HandlerInterceptorAdapter() {

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (AccessContext.isExistAccessContextOnThread()) {
            // 既に設定されていたら何もしないで次へ
            // (二度呼び出しされたときのために念のため)
            return true
        }
        // [アクセス日時]
        val accessLocalDateTime = Wolf4busyDateUtil.currentLocalDateTime()

        // [アクセスユーザ]
        val userInfo = Wolf4busyUserInfoUtil.getUserInfo()
        val accessUser = if (userInfo == null) "not login user" else userInfo!!.username

        val context = AccessContext()
        context.accessLocalDateTime = accessLocalDateTime
        context.accessUser = accessUser
        AccessContext.setAccessContextOnThread(context)

        // Handlerメソッドを呼び出す場合はtrueを返却する
        return true
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, @Nullable ex: java.lang.Exception?) {
        AccessContext.clearAccessContextOnThread()
    }
}