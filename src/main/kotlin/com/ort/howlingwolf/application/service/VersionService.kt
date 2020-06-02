package com.ort.howlingwolf.application.service

import com.ort.howlingwolf.domain.model.version.Version
import com.ort.howlingwolf.infrastructure.datasource.version.VersionDataSource
import org.springframework.stereotype.Service

@Service
class VersionService(
    val versionDataSource: VersionDataSource
) {

    fun findVersion(): Version {
        return versionDataSource.findVersion()
    }
}
