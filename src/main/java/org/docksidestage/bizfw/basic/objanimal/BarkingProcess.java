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
package org.docksidestage.bizfw.basic.objanimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The object for animal(動物).
 * @author ryuki sakuma
 */
public class BarkingProcess {
    private static final Logger logger = LoggerFactory.getLogger(BarkingProcess.class);

    private final Animal animal;
    public BarkingProcess(Animal animal) {
        this.animal = animal;
    }

    // TODO Animal にも breathIn メソッドが残っているので重複しています。 by subaru (2020/04/23)
    // リファクタなので、そうならないようにうまく改善してみましょう。
    // prepareAbdominalMuscle, doBark, downHitPoint メソッドなどについても同様です。
    protected void breatheIn() {
        logger.debug("...Breathing in");
        downHitPoint();
    }

    protected void prepareAbdominalMuscle() {
        logger.debug("...Using my abdominal muscle");
        downHitPoint();
    }

    public BarkedSound doBark() {
        downHitPoint();
        ;
        return new BarkedSound(animal.getBarkWord());
    }

    protected void downHitPoint() {
        --animal.hitPoint;
        if (animal.hitPoint == 0) {
            throw new IllegalStateException("I'm very tired, so I want to sleep" + animal.getBarkWord());
        }
    }

    public Animal getAnimal() {
        return animal;
    }
}
