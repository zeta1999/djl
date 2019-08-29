/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package software.amazon.ai.examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import software.amazon.ai.examples.inference.ClassifyExample;
import software.amazon.ai.examples.inference.util.AbstractExample;
import software.amazon.ai.modality.Classification;

public class ClassifyExampleTest {

    private static final String MODEL_NAME = "resnet18_v1";

    @Test
    public void testClassifyExample() {
        String[] args = {
            "-n", MODEL_NAME, "-i", "src/test/resources/kitten.jpg", "-c", "1", "-l", "build/logs"
        };
        Assert.assertTrue(new ClassifyExample().runExample(args));
        Classification result = (Classification) AbstractExample.getPredictResult();
        Assert.assertEquals(result.getClassName(), "n02123045 tabby, tabby cat");
        Assert.assertTrue(Double.compare(result.getProbability(), 0.4) > 0);
    }
}
