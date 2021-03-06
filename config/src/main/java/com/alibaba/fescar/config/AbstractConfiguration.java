/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.alibaba.fescar.config;

/**
 * The type Abstract configuration.
 *
 * @param <T> the type parameter
 * @Author: jimin.jm @alibaba-inc.com
 * @Project: fescar -all
 * @DateTime: 2019 /2/1 2:18 PM
 * @FileName: AbstractConfiguration
 * @Description:
 */
public abstract class AbstractConfiguration<T> implements Configuration<T> {

    /**
     * The constant DEFAULT_CONFIG_TIMEOUT.
     */
    protected static final long DEFAULT_CONFIG_TIMEOUT = 5 * 1000;
    protected static final String FILE_ROOT_REGISTRY = "registry";
    protected static final String FILE_CONFIG_SPLIT_CHAR = ".";

    @Override
    public int getInt(String dataId, int defaultValue, long timeoutMills) {
        String result = getConfig(dataId, String.valueOf(defaultValue), timeoutMills);
        return Integer.valueOf(result).intValue();
    }

    @Override
    public int getInt(String dataId, int defaultValue) {
        return getInt(dataId, defaultValue, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public int getInt(String dataId) {
        return getInt(dataId, 0);
    }

    @Override
    public long getLong(String dataId, long defaultValue, long timeoutMills) {
        String result = getConfig(dataId, String.valueOf(defaultValue), timeoutMills);
        return Long.valueOf(result).longValue();
    }

    @Override
    public long getLong(String dataId, long defaultValue) {
        return getLong(dataId, defaultValue, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public long getLong(String dataId) {
        return getLong(dataId, 0L);
    }

    @Override
    public boolean getBoolean(String dataId, boolean defaultValue, long timeoutMills) {
        String result = getConfig(dataId, String.valueOf(defaultValue), timeoutMills);
        return Boolean.valueOf(result).booleanValue();
    }

    @Override
    public boolean getBoolean(String dataId, boolean defaultValue) {
        return getBoolean(dataId, defaultValue, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public boolean getBoolean(String dataId) {
        return getBoolean(dataId, false);
    }

    @Override
    public String getConfig(String dataId, String defaultValue) {
        return getConfig(dataId, defaultValue, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public String getConfig(String dataId, long timeoutMills) {
        return getConfig(dataId, null, timeoutMills);
    }

    @Override
    public String getConfig(String dataId) {
        return getConfig(dataId, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public boolean putConfig(String dataId, String content) {
        return putConfig(dataId, content, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public boolean putConfigIfAbsent(String dataId, String content) {
        return putConfigIfAbsent(dataId, content, DEFAULT_CONFIG_TIMEOUT);
    }

    @Override
    public boolean removeConfig(String dataId) {
        return removeConfig(dataId, DEFAULT_CONFIG_TIMEOUT);
    }

    public abstract String getTypeName();
}
