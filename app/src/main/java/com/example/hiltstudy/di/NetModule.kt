package com.example.hiltstudy.di

import com.example.hiltstudy.net.HttpClient
import com.example.hiltstudy.net.HttpUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

/**
 * 理解为一个Dagger模块
 */
@Module
// 添加这行，指定模块安装在SingletonComponent中。
// 好像没啥用，应该在Dagger中使用的
// @InstallIn(SingletonComponent::class)

// 通过在模块上添加注解来在模块级别禁用检查
@DisableInstallInCheck
class NetModule {
    @Provides
    fun providerHttpUtil(httpClient: HttpClient): HttpUtil {
        return HttpUtil(httpClient)
    }

    @Provides
    fun providerHttpClient(): HttpClient {
        return HttpClient()
    }
}