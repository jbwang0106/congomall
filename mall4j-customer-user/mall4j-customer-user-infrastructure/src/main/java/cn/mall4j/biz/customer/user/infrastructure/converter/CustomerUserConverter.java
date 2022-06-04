/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.mall4j.biz.customer.user.infrastructure.converter;

import cn.mall4j.biz.customer.user.domain.entity.CustomerUser;
import cn.mall4j.biz.customer.user.infrastructure.dao.CustomerUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * C 端用户 Entity 转换 DO
 *
 * @author chen.ma
 * @github https://github.com/mabaiwan
 */
@Mapper(componentModel = "spring")
public interface CustomerUserConverter {
    
    /**
     * C 端用户 Entity 转换 DO
     *
     * @param customerUser
     * @return
     */
    @Mappings({
            @Mapping(source = "customerUser.username", target = "name"),
            @Mapping(source = "customerUser.phone", target = "phone"),
            @Mapping(source = "customerUser.password.password", target = "password"),
            @Mapping(source = "customerUser.accountNumber", target = "accountNumber")
    })
    CustomerUserDO customerUserToDO(CustomerUser customerUser);
    
    /**
     * C 端用户 DO 转换 Entity
     *
     * @param customerUserDO
     * @return
     */
    @Mappings({
            @Mapping(source = "id", target = "customerUserId"),
            @Mapping(source = "name", target = "username.username"),
            @Mapping(source = "mail", target = "mail.mail"),
            @Mapping(source = "phone", target = "phone.phone"),
            @Mapping(source = "password", target = "password.password"),
            @Mapping(source = "accountNumber", target = "accountNumber.accountNumber")
    })
    CustomerUser doToCustomerUser(CustomerUserDO customerUserDO);
}
