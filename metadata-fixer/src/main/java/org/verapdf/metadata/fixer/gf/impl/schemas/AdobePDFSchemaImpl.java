package org.verapdf.metadata.fixer.gf.impl.schemas;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.impl.VeraPDFMeta;
import org.verapdf.metadata.fixer.entity.Metadata;
import org.verapdf.metadata.fixer.schemas.AdobePDF;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maksim Bezrukov
 */
public class AdobePDFSchemaImpl extends BasicSchemaImpl implements AdobePDF {
	private static final Logger LOGGER = Logger.getLogger(AdobePDFSchemaImpl.class.getCanonicalName());

	public AdobePDFSchemaImpl(VeraPDFMeta meta, Metadata metadata) {
		super(meta, metadata);
	}

	@Override
	public String getProducer() {
		try {
			return this.meta.getProducer();
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get producer.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setProducer(String producer) {
		try {
			this.meta.setProducer(producer);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set producer.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public String getKeywords() {
		try {
			return this.meta.getKeywords();
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not get keywords.", e);
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void setKeywords(String keywords) {
		try {
			this.meta.setKeywords(keywords);
		} catch (XMPException e) {
			LOGGER.log(Level.FINE, "Can not set keywords.", e);
			throw new IllegalStateException(e);
		}
	}

}
