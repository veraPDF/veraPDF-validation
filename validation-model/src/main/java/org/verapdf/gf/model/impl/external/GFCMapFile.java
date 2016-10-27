package org.verapdf.gf.model.impl.external;

import org.verapdf.cos.COSStream;
import org.verapdf.model.external.CMapFile;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents embedded CMap file.
 *
 * @author Sergey Shemyakov
 */
public class GFCMapFile extends GFExternal implements CMapFile {

    private static final Logger LOGGER = Logger.getLogger(GFCMapFile.class.getCanonicalName());

    private org.verapdf.pd.font.cmap.CMapFile cMapFile;

    /**
     * Type name for GFCMapFile
     */
    public static final String CMAP_FILE_TYPE = "CMapFile";

    /**
     * Constructor from COSStream containing CMap.
     *
     * @param stream is CMap stream.
     */
    public GFCMapFile(COSStream stream) {
        super(CMAP_FILE_TYPE);
        this.cMapFile = new org.verapdf.pd.font.cmap.CMapFile(stream);
    }

    /**
     * @return the value of the WMode entry in the embedded CMap file.
     */
    @Override
    public Long getWMode() {
        try {
            return new Long(cMapFile.getWMode());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error in parsing embedded CMap file");
            e.printStackTrace();
            return new Long(-1);
        }
    }

    /**
     * @return the value of the WMode entry in the parent CMap dictionary.
     */
    @Override
    public Long getdictWMode() {
        return new Long(cMapFile.getDictWMode());
    }
}
