package me.lovesasuna.bot.file

import me.lovesasuna.bot.Main
import me.lovesasuna.bot.data.NoticeData
import me.lovesasuna.bot.function.Notice
import me.lovesasuna.bot.util.interfaces.file.FileManipulate
import java.io.*

object NoticeFile : FileManipulate {
    private val noticeFile = File(Main.dataFolder.toString() + File.separator + "notice.dat")

    override fun writeDefault() {
        throw UnsupportedOperationException("Nothing can be wrote out!")
    }

    override fun writeValue() {
        ObjectOutputStream(FileOutputStream(File(Main.dataFolder.toString() + File.separator + "notice.dat"))).writeObject(Notice.data)
    }

    override fun readValue() {
        if (noticeFile.exists()) {
            Notice.data = ObjectInputStream(FileInputStream(noticeFile)).readObject() as NoticeData
        }
    }
}