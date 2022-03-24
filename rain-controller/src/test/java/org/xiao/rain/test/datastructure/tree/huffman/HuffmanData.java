package org.xiao.rain.test.datastructure.tree.huffman;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * huffman 返回数据
 * Author: xiaojl
 * Date: 2021/12/12 22:40
 */
public class HuffmanData implements Serializable {

    private static final long serialVersionUID = -7031929043127018312L;
    private List<Byte> bytes;
    private String lastString;
    private Map<Byte, String> bytePathMap;

    public List<Byte> getBytes() {
        return bytes;
    }

    public void setBytes(List<Byte> bytes) {
        this.bytes = bytes;
    }

    public String getLastString() {
        return lastString;
    }

    public void setLastString(String lastString) {
        this.lastString = lastString;
    }

    public Map<Byte, String> getBytePathMap() {
        return bytePathMap;
    }

    public void setBytePathMap(Map<Byte, String> bytePathMap) {
        this.bytePathMap = bytePathMap;
    }
}
