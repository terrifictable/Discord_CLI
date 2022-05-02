package xyz.terrific.mod.utils

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL

class HTTPUtils {
    companion object {

        fun post(url: String, content: String, token: String = ""): String {
            val result: StringBuilder = StringBuilder();

            val site = URL(url)

            val conn = site.openConnection()
            conn.doOutput = true
            conn.setRequestProperty("Content-Type",   "application/x-www-form-urlencoded")
            conn.setRequestProperty("Content-Length", content.length.toString())
            if (token != "") {
                conn.setRequestProperty("Authorization", token)
            }

            DataOutputStream(conn.getOutputStream()).use { it.writeBytes(content) }
            try {
                BufferedReader(InputStreamReader(conn.getInputStream())).use { bf ->
                    var line: String?
                    while (bf.readLine().also { line = it } != null) {
                        result.append(line + "\n")
                    }
                }
            } catch (e: Exception) {
                print(e.message)
            }

            return result.toString()
        }

        fun get(url: String): String {
            val result: StringBuilder = StringBuilder()

            val site = URL(url)
            val connection = site.openConnection()

            BufferedReader(InputStreamReader(connection.getInputStream())).use { inp ->
                var line: String?
                while (inp.readLine().also { line = it } != null) {
                    result.append(line + "\n")
                }
            }

            return result.toString()
        }

    }
}
