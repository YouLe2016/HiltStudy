package com.example.hiltstudy.di.module

import android.content.Context
import com.example.hiltstudy.net.HttpClient
import com.example.hiltstudy.net.HttpUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

/**
 * 理解为一个Dagger模块
 */
@Module
// 添加这行，指定模块安装在SingletonComponent中。
// 好像没啥用，应该在Dagger中使用的
// @InstallIn(SingletonComponent::class)

// 通过在模块上添加注解来在模块级别禁用检查
@DisableInstallInCheck
object NetModule {
    @Provides
    // 配合Component上的@Singleton注解一起使用，指定模块作用域为单例
    @Singleton
    fun providerHttpUtil(httpClient: HttpClient, context: Context): HttpUtil {
        return HttpUtil(httpClient, context)
    }

    @Provides
    @Singleton
    fun providerHttpClient(): HttpClient {
        return HttpClient()
    }
}