package com.ort.wolf4busy.fw.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import javax.annotation.PostConstruct


@Configuration
class FirebaseConfig {

    @Value("\${firebase.adminsdk.secretkey.path}")
    private val firebaseAdminsdkSecretkeyPath: String? = null

    @Value("\${firebase.database.url}")
    private val firebaseDatabaseUrl: String? = null

    @Bean
    fun firebaseDatabase(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference
    }

    @PostConstruct
    fun init() {
        /**
         * https://firebase.google.com/docs/server/setup
         *
         * Create service account , download json
         */
        if (FirebaseApp.getApps().isNotEmpty()) {
            return
        }
        val serviceAccount = FileInputStream(firebaseAdminsdkSecretkeyPath)
        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl(firebaseDatabaseUrl)
            .build()
        FirebaseApp.initializeApp(options)
    }
}