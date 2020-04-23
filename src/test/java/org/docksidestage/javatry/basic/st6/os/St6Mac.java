/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.basic.st6.os;

/**
 * @author ryuki sakuma
 */
public class St6Mac extends St6OperationSystem {

    public St6Mac(String loginId) {
        super(loginId);
    }

    // TODO 細かいけど @Override を明示的につけた方がわかりやすいです。 by subaru (2020/04/23)
    // 他の具象クラスも同様です。
    public String getFileSeparator() {
        return "/";
    }

    public String getUserDirectory() {
        return "/Users/" + super.loginId;
    }
}
