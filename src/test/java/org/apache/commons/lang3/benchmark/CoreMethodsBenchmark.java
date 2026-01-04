/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.commons.lang3.benchmark;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@State(Scope.Thread)
public class CoreMethodsBenchmark {

    private String emptyString;
    private String nonEmptyString;
    private String mixedString;

    @Setup
    public void setup() {
        emptyString = "";
        nonEmptyString = "HelloWorld";
        mixedString = "a1b2c3d4";
    }

    @Benchmark
    public boolean benchmarkIsEmpty() {
        return StringUtils.isEmpty(emptyString);
    }

    @Benchmark
    public boolean benchmarkContains() {
        return StringUtils.contains(nonEmptyString, 'W');
    }

    @Benchmark
    public String benchmarkGetDigits() {
        return StringUtils.getDigits(mixedString);
    }
}
