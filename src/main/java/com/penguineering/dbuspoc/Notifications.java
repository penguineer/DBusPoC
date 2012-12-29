package com.penguineering.dbuspoc;

import java.util.Map;

import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusInterfaceName;
import org.freedesktop.dbus.UInt32;

@DBusInterfaceName("org.freedesktop.Notifications")
public interface Notifications extends DBusInterface {
	public UInt32 Notify(String app_name, UInt32 replaces_id, String app_icon,
			String body, String[] actions, Map<String, String> hints,
			UInt32 expire_timeout);
}
