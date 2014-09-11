/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

/**
 * @version 2014/09/11 15:14:54
 */
public class CHAR {

    public static void main(String[] a) {
        String v = "〡 ㄍㄑ﹟ーヽヿヾヰゝゞ〃〄々〆〇〈〉《》「」『』〜〝〞〟〨〧〦〥〤〣〢〡〰〱〲〳〴〵〻ᐩᐨ ᐳᐸᐦᐡᐢᐣᐞᓬᔓᔕᔑᔐᔪᔭᕀᕁᕒᕽᐅᐊᐁᐂᐃᐄᐅᐆᐇᐈᐉᐊᐋᐌᐍᐏᐑᐒᐓᐔᐕᐖᐗᐘᐙᐚᐛᐫᐬᐭᐯᐮᐰᐱᐲᐳᐴᐵᐷᐸᐹᐺᐻᐼᐽᐾᐿᑀᑁᑂᑃᑄᑅᑆᑇᑈ";

        for (int i = 0; i < v.length(); i++) {
            char c = v.charAt(i);

            if (Character.isJavaIdentifierStart(c)) {
                System.out.println(c);
            }
        }

        CHAR value = new CHAR();
        value.ᐩ(10).ᐨ(20).ᐳ(20).ᕁ(30);
    }

    public CHAR ᐩ(int value) {
        return this;
    }

    public CHAR ᐨ(int value) {
        return this;
    }

    public CHAR ᐳ(int value) {
        return this;
    }

    public CHAR ᐸ(int value) {
        return this;
    }

    public CHAR ㄍ(int value) {
        return this;
    }

    public CHAR 〡(int value) {
        return this;
    }

    public CHAR ᕀ(int value) {
        return this;
    }

    public CHAR ᕁ(int value) {
        return this;
    }

    public CHAR ﹟(int value) {
        return this;
    }
}
