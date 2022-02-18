/*
 * MIT License
 *
 * Copyright (c) 2021 Geekific (https://www.youtube.com/c/Geekific)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice, Geekific's channel link and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.observer;

import static com.example.observer.Event.*;

public class MainApp {

    public static void main(String[] args) {

        Store store = new Store();
        store.getService().subscribe(NEW_ITEM, new EmailMsgListener("geek@like.com"));
        store.getService().subscribe(SALE, new EmailMsgListener("geek@like.com"));
        store.getService().subscribe(SALE, new EmailMsgListener("geek@subs.com"));
        store.getService().subscribe(NEW_ITEM, new MobileAppListener("geek"));

        store.newItemPromotion();

        System.out.println("===============================================================");

        store.salePromotion();

        System.out.println("===============================================================");

        store.getService().unsubscribe(SALE, new EmailMsgListener("geek@like.com"));
        store.salePromotion();

    }

}
