package org.docksidestage.bizfw.debug;

/**
 * @author zaya
 */
public class Word {
    private Language language;
    private String word;

    public Word(Language language, String word) {
        this.language = language;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public Language getLanguage() {
        return language;
    }

    public boolean hasLanguage() {
        if (getLanguage() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Word{" + "language=" + language + ", word='" + word + '\'' + '}';
    }
}
