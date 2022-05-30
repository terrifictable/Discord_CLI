package xyz.terrific.utils

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL

class HTTPUtils {
    companion object {

        /**
         * Send Post Request
         * @param url Url to post data to
         * @param content the data that is supposed to be posted
         * @param token used in case you want to send discord message
         */
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

        /**
         * Send Get Request
         * @param url Url to get send get request to
         */
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
