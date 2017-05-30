/*
 * Copyright (c) 2017 Aniket Divekar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pinterest4j.util.list;

import pinterest4j.api.BaseResponse;
import pinterest4j.entity.RateLimitStatus;

import java.util.List;

/**
 * List of Pinterest Response
 *
 * Created by Aniket Divekar.
 */
public interface ResponseList<T> extends BaseResponse, List<T> {

    @Override
    RateLimitStatus getRateLimitStatus();
}
