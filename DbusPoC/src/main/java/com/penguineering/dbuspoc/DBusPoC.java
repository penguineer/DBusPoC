package com.penguineering.dbuspoc;

import java.text.ParseException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.exceptions.DBusException;

public class DBusPoC {
	private static Log log = LogFactory.getLog(DBusPoC.class);

	/**
	 * @param args
	 * @throws DBusException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws DBusException, ParseException {
		log.info("Hallo Welt!");

		DBusConnection con = DBusConnection
				.getConnection(DBusConnection.SESSION);

		log.info("DBus address: " + con.getAddress());

		Notifications notify = con.getRemoteObject(
				"org.freedesktop.Notifications",
				"/org/freedesktop/Notifications", Notifications.class);

		notify.Notify("Test", new UInt32(0), null, "Testnotification",
				new String[] {}, null, new UInt32(0));

		log.info("Disconnecting.");
		con.disconnect();

		log.info("Finished");
	}

}
