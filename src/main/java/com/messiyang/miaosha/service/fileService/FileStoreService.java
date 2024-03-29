package com.messiyang.miaosha.service.fileService;

/**
 * 文件存储管理
 * @author messiyang
 */
public interface FileStoreService {
    /**
     * 保存文件到物理磁盘
     * @param fileData 文件数据
     * @param filename 文件名，不含后缀
     * @param fileExt 文件后缀
     * @return 成功时，返回已存储文件的相对路径。
     */
    String store(byte[] fileData, String filename, String fileExt);

    /**
     * 删除文件
     * @param path 要删除的文件路径
     * @return true 删除成功<br />
     *          false 删除失败
     */
    boolean delete(String path);

    /**
     * 读取文件
     * @param path 要读取的文件的path
     * @return null：当文件不存在或出现异常时<br />
     *     *    byte[]：对应文件的数据
     */
    byte[] readFile(String path);

    /**
     * 获得文件的全路径
     * @param relativeFullName 文件的相对路径
     * @return
     */
    String getFullPath(String relativeFullName);
}
