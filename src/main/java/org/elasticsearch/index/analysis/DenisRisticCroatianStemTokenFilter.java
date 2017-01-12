package org.elasticsearch.index.analysis;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
import org.apache.lucene.analysis.util.CharArraySet;

public class DenisRisticCroatianStemTokenFilter extends TokenFilter {
  private final DenisRisticCroatianStemmer stemmer;
	private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
	private final KeywordAttribute keywordAttr = addAttribute(KeywordAttribute.class);

	public DenisRisticCroatianStemTokenFilter(TokenStream input)
	{
		super(input);
    	this.stemmer = new DenisRisticCroatianStemmer();
	}

	@Override
	public boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
			if (!keywordAttr.isKeyword()) {
				final int newlen = stemmer.stem(termAtt.buffer(), termAtt.length());
				termAtt.setLength(newlen);
			}
			return true;
		} else {
			return false;
		}
	}
}
