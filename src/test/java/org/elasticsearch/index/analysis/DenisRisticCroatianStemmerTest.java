package org.elasticsearch.index.analysis;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DenisRisticCroatianStemmerTest {
  private final DenisRisticCroatianStemmer stemmer = new DenisRisticCroatianStemmer();
  
  private static final String[] words = { "hrvatske", "crvene", "bicikle", "crveno", "crveni", "crvenovo", "gledajući", "gledati"};

  private static final String[] stems = { "hrvatsk", "crven", "bicikl", "crven", "crven", "crvenov", "gleda", "gleda"};

  private char[] token;
  private String stem;
  private int tokenLength, stemLength;

  @Test()
  public void testDenisRisticCroatianStemmer() {
    for (int i = 0; i < words.length; i++) {
      
      token = words[i].toCharArray();
      tokenLength = words[i].length();
      stemLength = stemmer.stem(token, tokenLength);
      stem = new String(token, 0, stemLength);

      System.out.println("Invoked testString " + words[i] + " => " + stem);

      Assert.assertEquals(stem, stems[i]);
    }
  }

}
