package org.verapdf.metadata.fixer.gf.impl.model;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.COSObject;
import org.verapdf.metadata.fixer.entity.InfoDictionary;
import org.verapdf.metadata.fixer.gf.utils.DateConverter;

/**
 * @author Maksim Bezrukov
 */
public class InfoDictionaryImpl implements InfoDictionary {

	private final COSObject info;

	public InfoDictionaryImpl(COSObject info) {
		if (info == null || info.empty()) {
			throw new IllegalArgumentException("Info dictionary representation can not be null");
		}
		this.info = info;
	}

	@Override
	public String getTitle() {
		return this.info.getStringKey(ASAtom.TITLE);
	}

	@Override
	public void setTitle(String title) {
		this.info.setStringKey(ASAtom.TITLE, title);
	}

	@Override
	public String getSubject() {
		return this.info.getStringKey(ASAtom.SUBJECT);
	}

	@Override
	public void setSubject(String subject) {
		this.info.setStringKey(ASAtom.SUBJECT, subject);
	}

	@Override
	public String getAuthor() {
		return this.info.getStringKey(ASAtom.AUTHOR);
	}

	@Override
	public void setAuthor(String author) {
		this.info.setStringKey(ASAtom.AUTHOR, author);
	}

	@Override
	public String getProducer() {
		return this.info.getStringKey(ASAtom.PRODUCER);
	}

	@Override
	public void setProducer(String producer) {
		this.info.setStringKey(ASAtom.PRODUCER, producer);
	}

	@Override
	public String getKeywords() {
		return this.info.getStringKey(ASAtom.KEYWORDS);
	}

	@Override
	public void setKeywords(String keywords) {
		this.info.setStringKey(ASAtom.KEYWORDS, keywords);
	}

	@Override
	public String getCreator() {
		return this.info.getStringKey(ASAtom.CREATOR);
	}

	@Override
	public void setCreator(String creator) {
		this.info.setStringKey(ASAtom.CREATOR, creator);
	}

	@Override
	public String getCreationDate() {
		return this.info.getStringKey(ASAtom.CREATION_DATE);
	}

	@Override
	public void setCreationDate(String creationDate) {
		this.info.setStringKey(ASAtom.CREATION_DATE, DateConverter.toPDFFormat(creationDate));
	}

	@Override
	public String getModificationDate() {
		return this.info.getStringKey(ASAtom.MOD_DATE);
	}

	@Override
	public void setModificationDate(String modificationDate) {
		this.info.setStringKey(ASAtom.MOD_DATE, DateConverter.toPDFFormat(modificationDate));
	}

	@Override
	public boolean isNeedToBeUpdated() {
		return this.info.isNeedToBeUpdated();
	}

	@Override
	public void setNeedToBeUpdated(boolean needToBeUpdated) {
		this.info.setNeedToBeUpdated(true);
	}

}
