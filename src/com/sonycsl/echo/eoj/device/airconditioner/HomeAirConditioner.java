/*
 * Copyright 2012 Sony Computer Science Laboratories, Inc. <info@kadecot.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sonycsl.echo.eoj.device.airconditioner;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class HomeAirConditioner extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = HomeAirConditioner.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x30;

	protected static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	protected static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	protected static final byte EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING = (byte)0xB2;
	protected static final byte EPC_SET_TEMPERATURE_VALUE = (byte)0xB3;
	protected static final byte EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE = (byte)0xB4;
	protected static final byte EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE = (byte)0xB5;
	protected static final byte EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE = (byte)0xB6;
	protected static final byte EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE = (byte)0xB7;
	protected static final byte EPC_RATED_POWER_CONSUMPTION = (byte)0xB8;
	protected static final byte EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION = (byte)0xB9;
	protected static final byte EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xBA;
	protected static final byte EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE = (byte)0xBB;
	protected static final byte EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL = (byte)0xBC;
	protected static final byte EPC_MEASURED_COOLED_AIR_TEMPERATURE = (byte)0xBD;
	protected static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE = (byte)0xBE;
	protected static final byte EPC_RELATIVE_TEMPERATURE_SETTING = (byte)0xBF;
	protected static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	protected static final byte EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING = (byte)0xA1;
	protected static final byte EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING = (byte)0xA3;
	protected static final byte EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING = (byte)0xA4;
	protected static final byte EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING = (byte)0xA5;
	protected static final byte EPC_SPECIAL_STATE = (byte)0xAA;
	protected static final byte EPC_NON_PRIORITY_STATE = (byte)0xAB;
	protected static final byte EPC_VENTILATION_FUNCTION_SETTING = (byte)0xC0;
	protected static final byte EPC_HUMIDIFIER_FUNCTION_SETTING = (byte)0xC1;
	protected static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	protected static final byte EPC_DEGREE_OF_HUMIDIFICATION_SETTING = (byte)0xC4;
	protected static final byte EPC_MOUNTED_AIR_CLEANING_METHOD = (byte)0xC6;
	protected static final byte EPC_AIR_PURIFIER_FUNCTION_SETTING = (byte)0xC7;
	protected static final byte EPC_MOUNTED_AIR_REFRESH_METHOD = (byte)0xC8;
	protected static final byte EPC_AIR_REFRESHER_FUNCTION_SETTING = (byte)0xC9;
	protected static final byte EPC_MOUNTED_SELF_CLEANING_METHOD = (byte)0xCA;
	protected static final byte EPC_SELF_CLEANING_FUNCTION_SETTING = (byte)0xCB;
	protected static final byte EPC_SPECIAL_FUNCTION_SETTING = (byte)0xCC;
	protected static final byte EPC_OPERATION_STATUS_OF_COMPONENTS = (byte)0xCD;
	protected static final byte EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION = (byte)0xCE;
	protected static final byte EPC_AIR_PURIFICATION_MODE_SETTING = (byte)0xCF;
	protected static final byte EPC_ON_TIMER_BASED_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	protected static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	protected static final byte EPC_OFF_TIMER_BASED_RESERVATION_SETTING = (byte)0x94;
	protected static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	protected static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME = (byte)0x96;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	/**
	 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
	 */
	protected abstract byte[] getOperationModeSetting();
	/**
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
	 */
	protected boolean setNormalHighSpeedSilentOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
	 */
	protected byte[] getNormalHighSpeedSilentOperationSetting() {return null;}
	/**
	 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected abstract boolean setSetTemperatureValue(byte[] edt);
	/**
	 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected abstract byte[] getSetTemperatureValue();
	/**
	 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
	 */
	protected boolean setSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {return false;}
	/**
	 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
	 */
	protected byte[] getSetValueOfRelativeHumidityInDehumidifyingMode() {return null;}
	/**
	 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected boolean setSetTemperatureValueInCoolingMode(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected byte[] getSetTemperatureValueInCoolingMode() {return null;}
	/**
	 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected boolean setSetTemperatureValueInHeatingMode(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected byte[] getSetTemperatureValueInHeatingMode() {return null;}
	/**
	 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected boolean setSetTemperatureValueInDehumidifyingMode(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
	 */
	protected byte[] getSetTemperatureValueInDehumidifyingMode() {return null;}
	/**
	 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	/**
	 * Measured value of current consumption<br>0x0000.0xFFFD (0.6553.3A)
	 */
	protected byte[] getMeasuredValueOfCurrentConsumption() {return null;}
	/**
	 * Measured value of room relative humidity<br>0x00.0x64 (0.100. C)
	 */
	protected byte[] getMeasuredValueOfRoomRelativeHumidity() {return null;}
	/**
	 * Measured value of room temperature<br>0x80.0x7D (-127.125.C)
	 */
	protected byte[] getMeasuredValueOfRoomTemperature() {return null;}
	/**
	 * Set temperature value of user remote control<br>0x00.0x32 (0.50.C)
	 */
	protected byte[] getSetTemperatureValueOfUserRemoteControl() {return null;}
	/**
	 * This property indicates the measured cooled air temperature at the outlet.<br>0x81 to 0x7D (-127 to 125��C)
	 */
	protected byte[] getMeasuredCooledAirTemperature() {return null;}
	/**
	 * This property indicates the measured outdoor air temperature.<br>0x81 to 0x7D (-127 to 125��C)
	 */
	protected byte[] getMeasuredOutdoorAirTemperature() {return null;}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
	 */
	protected boolean setRelativeTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
	 */
	protected byte[] getRelativeTemperatureSetting() {return null;}
	/**
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	/**
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
	 */
	protected boolean setAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
	 */
	protected byte[] getAutomaticControlOfAirFlowDirectionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
	 */
	protected boolean setAutomaticSwingOfAirFlowSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
	 */
	protected byte[] getAutomaticSwingOfAirFlowSetting() {return null;}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
	 */
	protected boolean setAirFlowDirectionVerticalSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
	 */
	protected byte[] getAirFlowDirectionVerticalSetting() {return null;}
	/**
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
	 */
	protected boolean setAirFlowDirectionHorizontalSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
	 */
	protected byte[] getAirFlowDirectionHorizontalSetting() {return null;}
	/**
	 * This property indicates if the air conditioner is in a �gspecial�h state (i.e. the �gdefrosting,�h �gpreheating,�h or �gheat removal�h state).<br>�gNormal operation�h state = 0x40, �gDefrosting�h state = 0x41, �gPreheating�h state = 0x42, �gHeat removal�h state = 0x43
	 */
	protected byte[] getSpecialState() {return null;}
	/**
	 * Used to indicate when the air conditioner is in a �gnon-priority�h state.<br>�gNormal operation�h state = 0x40, �gNon-priority�h state = 0x41
	 */
	protected byte[] getNonPriorityState() {return null;}
	/**
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
	 */
	protected boolean setVentilationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
	 */
	protected byte[] getVentilationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
	 */
	protected boolean setHumidifierFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
	 */
	protected byte[] getHumidifierFunctionSetting() {return null;}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
	 */
	protected boolean setDegreeOfHumidificationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
	 */
	protected byte[] getDegreeOfHumidificationSetting() {return null;}
	/**
	 * A bitmap indicates mounted method of exercising air cleaning function.<br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
	 */
	protected byte[] getMountedAirCleaningMethod() {return null;}
	/**
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
	 */
	protected boolean setAirPurifierFunctionSetting(byte[] edt) {return false;}
	/**
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
	 */
	protected byte[] getAirPurifierFunctionSetting() {return null;}
	/**
	 * A bitmap indicates mounted method for exercising refresh function.<br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
	 */
	protected byte[] getMountedAirRefreshMethod() {return null;}
	/**
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
	 */
	protected boolean setAirRefresherFunctionSetting(byte[] edt) {return false;}
	/**
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
	 */
	protected byte[] getAirRefresherFunctionSetting() {return null;}
	/**
	 * A bitmap indicates mounted method for exercising self-cleaning function.<br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted
	 */
	protected byte[] getMountedSelfCleaningMethod() {return null;}
	/**
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
	 */
	protected boolean setSelfCleaningFunctionSetting(byte[] edt) {return false;}
	/**
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
	 */
	protected byte[] getSelfCleaningFunctionSetting() {return null;}
	/**
	 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
	 */
	protected boolean setSpecialFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
	 */
	protected byte[] getSpecialFunctionSetting() {return null;}
	/**
	 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.
	 */
	protected byte[] getOperationStatusOfComponents() {return null;}
	/**
	 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	/**
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
	 */
	protected boolean setAirPurificationModeSetting(byte[] edt) {return false;}
	/**
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
	 */
	protected byte[] getAirPurificationModeSetting() {return null;}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
	 */
	protected boolean setOnTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
	 */
	protected byte[] getOnTimerBasedReservationSetting() {return null;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
	 */
	protected boolean setOffTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
	 */
	protected byte[] getOffTimerBasedReservationSetting() {return null;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, setOperationModeSetting(edt));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			res.addProperty(epc, edt, setAutomaticTemperatureControlSetting(edt));
			break;
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
			res.addProperty(epc, edt, setNormalHighSpeedSilentOperationSetting(edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE:
			res.addProperty(epc, edt, setSetTemperatureValue(edt));
			break;
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
			res.addProperty(epc, edt, setSetValueOfRelativeHumidityInDehumidifyingMode(edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
			res.addProperty(epc, edt, setSetTemperatureValueInCoolingMode(edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
			res.addProperty(epc, edt, setSetTemperatureValueInHeatingMode(edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
			res.addProperty(epc, edt, setSetTemperatureValueInDehumidifyingMode(edt));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setRelativeTemperatureSetting(edt));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setAirFlowRateSetting(edt));
			break;
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
			res.addProperty(epc, edt, setAutomaticControlOfAirFlowDirectionSetting(edt));
			break;
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
			res.addProperty(epc, edt, setAutomaticSwingOfAirFlowSetting(edt));
			break;
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
			res.addProperty(epc, edt, setAirFlowDirectionVerticalSetting(edt));
			break;
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
			res.addProperty(epc, edt, setAirFlowDirectionHorizontalSetting(edt));
			break;
		case EPC_VENTILATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, setVentilationFunctionSetting(edt));
			break;
		case EPC_HUMIDIFIER_FUNCTION_SETTING:
			res.addProperty(epc, edt, setHumidifierFunctionSetting(edt));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setVentilationAirFlowRateSetting(edt));
			break;
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
			res.addProperty(epc, edt, setDegreeOfHumidificationSetting(edt));
			break;
		case EPC_AIR_PURIFIER_FUNCTION_SETTING:
			res.addProperty(epc, edt, setAirPurifierFunctionSetting(edt));
			break;
		case EPC_AIR_REFRESHER_FUNCTION_SETTING:
			res.addProperty(epc, edt, setAirRefresherFunctionSetting(edt));
			break;
		case EPC_SELF_CLEANING_FUNCTION_SETTING:
			res.addProperty(epc, edt, setSelfCleaningFunctionSetting(edt));
			break;
		case EPC_SPECIAL_FUNCTION_SETTING:
			res.addProperty(epc, edt, setSpecialFunctionSetting(edt));
			break;
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
			res.addProperty(epc, edt, setThermostatSettingOverrideFunction(edt));
			break;
		case EPC_AIR_PURIFICATION_MODE_SETTING:
			res.addProperty(epc, edt, setAirPurificationModeSetting(edt));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerBasedReservationSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOnTimerSettingTime(edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOnTimerSettingRelativeTime(edt));
			break;
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOffTimerBasedReservationSetting(edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOffTimerSettingTime(edt));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOffTimerSettingRelativeTime(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			edt = getOperationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			edt = getAutomaticTemperatureControlSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
			edt = getNormalHighSpeedSilentOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE:
			edt = getSetTemperatureValue();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
			edt = getSetValueOfRelativeHumidityInDehumidifyingMode();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
			edt = getSetTemperatureValueInCoolingMode();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
			edt = getSetTemperatureValueInHeatingMode();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
			edt = getSetTemperatureValueInDehumidifyingMode();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_CONSUMPTION:
			edt = getRatedPowerConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION:
			edt = getMeasuredValueOfCurrentConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			edt = getMeasuredValueOfRoomRelativeHumidity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE:
			edt = getMeasuredValueOfRoomTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL:
			edt = getSetTemperatureValueOfUserRemoteControl();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_COOLED_AIR_TEMPERATURE:
			edt = getMeasuredCooledAirTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE:
			edt = getMeasuredOutdoorAirTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			edt = getRelativeTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			edt = getAirFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
			edt = getAutomaticControlOfAirFlowDirectionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
			edt = getAutomaticSwingOfAirFlowSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
			edt = getAirFlowDirectionVerticalSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
			edt = getAirFlowDirectionHorizontalSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPECIAL_STATE:
			edt = getSpecialState();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NON_PRIORITY_STATE:
			edt = getNonPriorityState();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_FUNCTION_SETTING:
			edt = getVentilationFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMIDIFIER_FUNCTION_SETTING:
			edt = getHumidifierFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			edt = getVentilationAirFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
			edt = getDegreeOfHumidificationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MOUNTED_AIR_CLEANING_METHOD:
			edt = getMountedAirCleaningMethod();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_PURIFIER_FUNCTION_SETTING:
			edt = getAirPurifierFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MOUNTED_AIR_REFRESH_METHOD:
			edt = getMountedAirRefreshMethod();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_REFRESHER_FUNCTION_SETTING:
			edt = getAirRefresherFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MOUNTED_SELF_CLEANING_METHOD:
			edt = getMountedSelfCleaningMethod();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SELF_CLEANING_FUNCTION_SETTING:
			edt = getSelfCleaningFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPECIAL_FUNCTION_SETTING:
			edt = getSpecialFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPERATION_STATUS_OF_COMPONENTS:
			edt = getOperationStatusOfComponents();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_PURIFICATION_MODE_SETTING:
			edt = getAirPurificationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			edt = getOnTimerBasedReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			edt = getOnTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			edt = getOnTimerSettingRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			edt = getOffTimerBasedReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = getOffTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			edt = getOffTimerSettingRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new SetterImpl(ESV_SET_NO_RES);
	}

	@Override
	public Setter setC() {
		return new SetterImpl(ESV_SET_RES);
	}

	@Override
	public Getter get() {
		return new GetterImpl();
	}

	@Override
	public Informer inform() {
		return new InformerImpl();
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				onSetOperationModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				onSetAutomaticTemperatureControlSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
				onSetNormalHighSpeedSilentOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE:
				onSetSetTemperatureValue(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
				onSetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
				onSetSetTemperatureValueInCoolingMode(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
				onSetSetTemperatureValueInHeatingMode(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
				onSetSetTemperatureValueInDehumidifyingMode(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				onSetRelativeTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				onSetAirFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
				onSetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
				onSetAutomaticSwingOfAirFlowSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
				onSetAirFlowDirectionVerticalSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
				onSetAirFlowDirectionHorizontalSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_FUNCTION_SETTING:
				onSetVentilationFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HUMIDIFIER_FUNCTION_SETTING:
				onSetHumidifierFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				onSetVentilationAirFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
				onSetDegreeOfHumidificationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING:
				onSetAirPurifierFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING:
				onSetAirRefresherFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SELF_CLEANING_FUNCTION_SETTING:
				onSetSelfCleaningFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SPECIAL_FUNCTION_SETTING:
				onSetSpecialFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
				onSetThermostatSettingOverrideFunction(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_PURIFICATION_MODE_SETTING:
				onSetAirPurificationModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				onSetOnTimerBasedReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onSetOnTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onSetOnTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				onSetOffTimerBasedReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onSetOffTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				onSetOffTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				onGetOperationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				onGetAutomaticTemperatureControlSetting(eoj, tid, pdc, edt);
				break;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
				onGetNormalHighSpeedSilentOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE:
				onGetSetTemperatureValue(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
				onGetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
				onGetSetTemperatureValueInCoolingMode(eoj, tid, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
				onGetSetTemperatureValueInHeatingMode(eoj, tid, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
				onGetSetTemperatureValueInDehumidifyingMode(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION:
				onGetRatedPowerConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION:
				onGetMeasuredValueOfCurrentConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE:
				onGetMeasuredValueOfRoomTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL:
				onGetSetTemperatureValueOfUserRemoteControl(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_COOLED_AIR_TEMPERATURE:
				onGetMeasuredCooledAirTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE:
				onGetMeasuredOutdoorAirTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				onGetRelativeTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				onGetAirFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
				onGetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
				onGetAutomaticSwingOfAirFlowSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
				onGetAirFlowDirectionVerticalSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
				onGetAirFlowDirectionHorizontalSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_STATE:
				onGetSpecialState(eoj, tid, pdc, edt);
				break;
			case EPC_NON_PRIORITY_STATE:
				onGetNonPriorityState(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_FUNCTION_SETTING:
				onGetVentilationFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HUMIDIFIER_FUNCTION_SETTING:
				onGetHumidifierFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				onGetVentilationAirFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
				onGetDegreeOfHumidificationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MOUNTED_AIR_CLEANING_METHOD:
				onGetMountedAirCleaningMethod(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING:
				onGetAirPurifierFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MOUNTED_AIR_REFRESH_METHOD:
				onGetMountedAirRefreshMethod(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING:
				onGetAirRefresherFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MOUNTED_SELF_CLEANING_METHOD:
				onGetMountedSelfCleaningMethod(eoj, tid, pdc, edt);
				break;
			case EPC_SELF_CLEANING_FUNCTION_SETTING:
				onGetSelfCleaningFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_FUNCTION_SETTING:
				onGetSpecialFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OPERATION_STATUS_OF_COMPONENTS:
				onGetOperationStatusOfComponents(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_PURIFICATION_MODE_SETTING:
				onGetAirPurificationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				onGetOnTimerBasedReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onGetOnTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onGetOnTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				onGetOffTimerBasedReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onGetOffTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				onGetOffTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
		 */
		protected void onSetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
		 */
		protected void onGetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onSetSetTemperatureValue(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onGetSetTemperatureValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		protected void onSetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		protected void onGetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onSetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onGetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onSetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onGetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onSetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		protected void onGetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured value of current consumption<br>0x0000.0xFFFD (0.6553.3A)
		 */
		protected void onGetMeasuredValueOfCurrentConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured value of room relative humidity<br>0x00.0x64 (0.100. C)
		 */
		protected void onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured value of room temperature<br>0x80.0x7D (-127.125.C)
		 */
		protected void onGetMeasuredValueOfRoomTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Set temperature value of user remote control<br>0x00.0x32 (0.50.C)
		 */
		protected void onGetSetTemperatureValueOfUserRemoteControl(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured cooled air temperature at the outlet.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		protected void onGetMeasuredCooledAirTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured outdoor air temperature.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		protected void onGetMeasuredOutdoorAirTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
		 */
		protected void onSetRelativeTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
		 */
		protected void onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
		 */
		protected void onSetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
		 */
		protected void onGetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
		 */
		protected void onSetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
		 */
		protected void onGetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
		 */
		protected void onSetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
		 */
		protected void onGetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
		 */
		protected void onSetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
		 */
		protected void onGetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates if the air conditioner is in a �gspecial�h state (i.e. the �gdefrosting,�h �gpreheating,�h or �gheat removal�h state).<br>�gNormal operation�h state = 0x40, �gDefrosting�h state = 0x41, �gPreheating�h state = 0x42, �gHeat removal�h state = 0x43
		 */
		protected void onGetSpecialState(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to indicate when the air conditioner is in a �gnon-priority�h state.<br>�gNormal operation�h state = 0x40, �gNon-priority�h state = 0x41
		 */
		protected void onGetNonPriorityState(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
		 */
		protected void onSetVentilationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
		 */
		protected void onGetVentilationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
		 */
		protected void onSetHumidifierFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
		 */
		protected void onGetHumidifierFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
		 */
		protected void onSetDegreeOfHumidificationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
		 */
		protected void onGetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * A bitmap indicates mounted method of exercising air cleaning function.<br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
		 */
		protected void onGetMountedAirCleaningMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
		 */
		protected void onSetAirPurifierFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
		 */
		protected void onGetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * A bitmap indicates mounted method for exercising refresh function.<br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
		 */
		protected void onGetMountedAirRefreshMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
		 */
		protected void onSetAirRefresherFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
		 */
		protected void onGetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted
		 */
		protected void onGetMountedSelfCleaningMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
		 */
		protected void onSetSelfCleaningFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
		 */
		protected void onGetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
		 */
		protected void onSetSpecialFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
		 */
		protected void onGetSpecialFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.
		 */
		protected void onGetOperationStatusOfComponents(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
		 */
		protected void onSetAirPurificationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
		 */
		protected void onGetAirPurificationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		protected void onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		protected void onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		protected void onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		protected void onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetPower(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimiting(byte[] edt);
		public Setter reqSetPowerSaving(byte[] edt);
		public Setter reqSetLocation(byte[] edt);
		public Setter reqSetCurrentTime(byte[] edt);
		public Setter reqSetCurrentDate(byte[] edt);
		public Setter reqSetPowerLimitation(byte[] edt);
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
		 */
		public Setter reqSetOperationModeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt);
		/**
		 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
		 */
		public Setter reqSetNormalHighSpeedSilentOperationSetting(byte[] edt);
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Setter reqSetSetTemperatureValue(byte[] edt);
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Setter reqSetSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt);
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Setter reqSetSetTemperatureValueInCoolingMode(byte[] edt);
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Setter reqSetSetTemperatureValueInHeatingMode(byte[] edt);
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Setter reqSetSetTemperatureValueInDehumidifyingMode(byte[] edt);
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
		 */
		public Setter reqSetAutomaticControlOfAirFlowDirectionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
		 */
		public Setter reqSetAutomaticSwingOfAirFlowSetting(byte[] edt);
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
		 */
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt);
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
		 */
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
		 */
		public Setter reqSetVentilationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
		 */
		public Setter reqSetHumidifierFunctionSetting(byte[] edt);
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt);
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
		 */
		public Setter reqSetDegreeOfHumidificationSetting(byte[] edt);
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
		 */
		public Setter reqSetAirPurifierFunctionSetting(byte[] edt);
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
		 */
		public Setter reqSetAirRefresherFunctionSetting(byte[] edt);
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
		 */
		public Setter reqSetSelfCleaningFunctionSetting(byte[] edt);
		/**
		 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
		 */
		public Setter reqSetSpecialFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt);
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
		 */
		public Setter reqSetAirPurificationModeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt);
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt);
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt);
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt);

	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
		}

		@Override
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, setOperationModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, setAutomaticTemperatureControlSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetNormalHighSpeedSilentOperationSetting(byte[] edt) {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt, setNormalHighSpeedSilentOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValue(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE, edt, setSetTemperatureValue(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt, setSetValueOfRelativeHumidityInDehumidifyingMode(edt));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValueInCoolingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt, setSetTemperatureValueInCoolingMode(edt));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValueInHeatingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt, setSetTemperatureValueInHeatingMode(edt));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValueInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt, setSetTemperatureValueInDehumidifyingMode(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, setRelativeTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, setAirFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt, setAutomaticControlOfAirFlowDirectionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticSwingOfAirFlowSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt, setAutomaticSwingOfAirFlowSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt, setAirFlowDirectionVerticalSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt, setAirFlowDirectionHorizontalSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationFunctionSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING, edt, setVentilationFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHumidifierFunctionSetting(byte[] edt) {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt, setHumidifierFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, setVentilationAirFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDegreeOfHumidificationSetting(byte[] edt) {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt, setDegreeOfHumidificationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirPurifierFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt, setAirPurifierFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirRefresherFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt, setAirRefresherFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSelfCleaningFunctionSetting(byte[] edt) {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt, setSelfCleaningFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSpecialFunctionSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING, edt, setSpecialFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, setThermostatSettingOverrideFunction(edt));
			return this;
		}
		@Override
		public Setter reqSetAirPurificationModeSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt, setAirPurificationModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, setOnTimerBasedReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, setOnTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, setOnTimerSettingRelativeTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, setOffTimerBasedReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, setOffTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, setOffTimerSettingRelativeTime(edt));
			return this;
		}

	}
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
		}

		@Override
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetNormalHighSpeedSilentOperationSetting(byte[] edt) {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValue(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValueInCoolingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValueInHeatingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetTemperatureValueInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticSwingOfAirFlowSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationFunctionSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHumidifierFunctionSetting(byte[] edt) {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDegreeOfHumidificationSetting(byte[] edt) {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirPurifierFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirRefresherFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSelfCleaningFunctionSetting(byte[] edt) {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSpecialFunctionSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirPurificationModeSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}

	}

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetPower();
		public Getter reqGetInstallationLocation();
		public Getter reqGetVersion();
		public Getter reqGetIdNumber();
		public Getter reqGetElectricityConsumption();
		public Getter reqGetPowerConsumption();
		public Getter reqGetMakerErrorCode();
		public Getter reqGetCurrentLimiting();
		public Getter reqGetError();
		public Getter reqGetErrorInfo();
		public Getter reqGetMakerCode();
		public Getter reqGetWorkplaceCode();
		public Getter reqGetProductCode();
		public Getter reqGetManufacturingNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetPowerSaving();
		public Getter reqGetLocation();
		public Getter reqGetCurrentTime();
		public Getter reqGetCurrentDate();
		public Getter reqGetPowerLimitation();
		public Getter reqGetWorkingTime();
		public Getter reqGetAnnoPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
		 */
		public Getter reqGetOperationModeSetting();
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
		 */
		public Getter reqGetAutomaticTemperatureControlSetting();
		/**
		 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
		 */
		public Getter reqGetNormalHighSpeedSilentOperationSetting();
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Getter reqGetSetTemperatureValue();
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Getter reqGetSetValueOfRelativeHumidityInDehumidifyingMode();
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Getter reqGetSetTemperatureValueInCoolingMode();
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Getter reqGetSetTemperatureValueInHeatingMode();
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Getter reqGetSetTemperatureValueInDehumidifyingMode();
		/**
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast
		 */
		public Getter reqGetRatedPowerConsumption();
		/**
		 * Measured value of current consumption<br>0x0000.0xFFFD (0.6553.3A)
		 */
		public Getter reqGetMeasuredValueOfCurrentConsumption();
		/**
		 * Measured value of room relative humidity<br>0x00.0x64 (0.100. C)
		 */
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity();
		/**
		 * Measured value of room temperature<br>0x80.0x7D (-127.125.C)
		 */
		public Getter reqGetMeasuredValueOfRoomTemperature();
		/**
		 * Set temperature value of user remote control<br>0x00.0x32 (0.50.C)
		 */
		public Getter reqGetSetTemperatureValueOfUserRemoteControl();
		/**
		 * This property indicates the measured cooled air temperature at the outlet.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		public Getter reqGetMeasuredCooledAirTemperature();
		/**
		 * This property indicates the measured outdoor air temperature.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature();
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
		 */
		public Getter reqGetRelativeTemperatureSetting();
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		public Getter reqGetAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
		 */
		public Getter reqGetAutomaticControlOfAirFlowDirectionSetting();
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
		 */
		public Getter reqGetAutomaticSwingOfAirFlowSetting();
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
		 */
		public Getter reqGetAirFlowDirectionVerticalSetting();
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
		 */
		public Getter reqGetAirFlowDirectionHorizontalSetting();
		/**
		 * This property indicates if the air conditioner is in a �gspecial�h state (i.e. the �gdefrosting,�h �gpreheating,�h or �gheat removal�h state).<br>�gNormal operation�h state = 0x40, �gDefrosting�h state = 0x41, �gPreheating�h state = 0x42, �gHeat removal�h state = 0x43
		 */
		public Getter reqGetSpecialState();
		/**
		 * Used to indicate when the air conditioner is in a �gnon-priority�h state.<br>�gNormal operation�h state = 0x40, �gNon-priority�h state = 0x41
		 */
		public Getter reqGetNonPriorityState();
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
		 */
		public Getter reqGetVentilationFunctionSetting();
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
		 */
		public Getter reqGetHumidifierFunctionSetting();
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
		 */
		public Getter reqGetVentilationAirFlowRateSetting();
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
		 */
		public Getter reqGetDegreeOfHumidificationSetting();
		/**
		 * A bitmap indicates mounted method of exercising air cleaning function.<br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
		 */
		public Getter reqGetMountedAirCleaningMethod();
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
		 */
		public Getter reqGetAirPurifierFunctionSetting();
		/**
		 * A bitmap indicates mounted method for exercising refresh function.<br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
		 */
		public Getter reqGetMountedAirRefreshMethod();
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
		 */
		public Getter reqGetAirRefresherFunctionSetting();
		/**
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted
		 */
		public Getter reqGetMountedSelfCleaningMethod();
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
		 */
		public Getter reqGetSelfCleaningFunctionSetting();
		/**
		 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
		 */
		public Getter reqGetSpecialFunctionSetting();
		/**
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.
		 */
		public Getter reqGetOperationStatusOfComponents();
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
		 */
		public Getter reqGetAirPurificationModeSetting();
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		public Getter reqGetOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		public Getter reqGetOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOffTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		public Getter reqGetOffTimerSettingRelativeTime();

	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			return (Getter)super.reqGetSetPropertyMap();
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			return (Getter)super.reqGetGetPropertyMap();
		}

		@Override
		public Getter reqGetOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticTemperatureControlSetting() {
			byte[] edt = getAutomaticTemperatureControlSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetNormalHighSpeedSilentOperationSetting() {
			byte[] edt = getNormalHighSpeedSilentOperationSetting();
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValue() {
			byte[] edt = getSetTemperatureValue();
			addProperty(EPC_SET_TEMPERATURE_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfRelativeHumidityInDehumidifyingMode() {
			byte[] edt = getSetValueOfRelativeHumidityInDehumidifyingMode();
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueInCoolingMode() {
			byte[] edt = getSetTemperatureValueInCoolingMode();
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueInHeatingMode() {
			byte[] edt = getSetTemperatureValueInHeatingMode();
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueInDehumidifyingMode() {
			byte[] edt = getSetTemperatureValueInDehumidifyingMode();
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumption() {
			byte[] edt = getRatedPowerConsumption();
			addProperty(EPC_RATED_POWER_CONSUMPTION, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfCurrentConsumption() {
			byte[] edt = getMeasuredValueOfCurrentConsumption();
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			byte[] edt = getMeasuredValueOfRoomRelativeHumidity();
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRoomTemperature() {
			byte[] edt = getMeasuredValueOfRoomTemperature();
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueOfUserRemoteControl() {
			byte[] edt = getSetTemperatureValueOfUserRemoteControl();
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCooledAirTemperature() {
			byte[] edt = getMeasuredCooledAirTemperature();
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredOutdoorAirTemperature() {
			byte[] edt = getMeasuredOutdoorAirTemperature();
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRelativeTemperatureSetting() {
			byte[] edt = getRelativeTemperatureSetting();
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			byte[] edt = getAirFlowRateSetting();
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticControlOfAirFlowDirectionSetting() {
			byte[] edt = getAutomaticControlOfAirFlowDirectionSetting();
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticSwingOfAirFlowSetting() {
			byte[] edt = getAutomaticSwingOfAirFlowSetting();
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirFlowDirectionVerticalSetting() {
			byte[] edt = getAirFlowDirectionVerticalSetting();
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirFlowDirectionHorizontalSetting() {
			byte[] edt = getAirFlowDirectionHorizontalSetting();
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSpecialState() {
			byte[] edt = getSpecialState();
			addProperty(EPC_SPECIAL_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetNonPriorityState() {
			byte[] edt = getNonPriorityState();
			addProperty(EPC_NON_PRIORITY_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationFunctionSetting() {
			byte[] edt = getVentilationFunctionSetting();
			addProperty(EPC_VENTILATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHumidifierFunctionSetting() {
			byte[] edt = getHumidifierFunctionSetting();
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			byte[] edt = getVentilationAirFlowRateSetting();
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDegreeOfHumidificationSetting() {
			byte[] edt = getDegreeOfHumidificationSetting();
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMountedAirCleaningMethod() {
			byte[] edt = getMountedAirCleaningMethod();
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirPurifierFunctionSetting() {
			byte[] edt = getAirPurifierFunctionSetting();
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMountedAirRefreshMethod() {
			byte[] edt = getMountedAirRefreshMethod();
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirRefresherFunctionSetting() {
			byte[] edt = getAirRefresherFunctionSetting();
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMountedSelfCleaningMethod() {
			byte[] edt = getMountedSelfCleaningMethod();
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSelfCleaningFunctionSetting() {
			byte[] edt = getSelfCleaningFunctionSetting();
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSpecialFunctionSetting() {
			byte[] edt = getSpecialFunctionSetting();
			addProperty(EPC_SPECIAL_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOperationStatusOfComponents() {
			byte[] edt = getOperationStatusOfComponents();
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirPurificationModeSetting() {
			byte[] edt = getAirPurificationModeSetting();
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerBasedReservationSetting() {
			byte[] edt = getOnTimerBasedReservationSetting();
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			byte[] edt = getOnTimerSettingTime();
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			byte[] edt = getOnTimerSettingRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerBasedReservationSetting() {
			byte[] edt = getOffTimerBasedReservationSetting();
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			byte[] edt = getOffTimerSettingRelativeTime();
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}

	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
		}

		@Override
		public Getter reqGetSetPropertyMap() {
			return (Getter)super.reqGetSetPropertyMap();
		}

		@Override
		public Getter reqGetGetPropertyMap() {
			return (Getter)super.reqGetGetPropertyMap();
		}

		@Override
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetNormalHighSpeedSilentOperationSetting() {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValue() {
			addProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfRelativeHumidityInDehumidifyingMode() {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueInCoolingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueInHeatingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueInDehumidifyingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfCurrentConsumption() {
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRoomTemperature() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetSetTemperatureValueOfUserRemoteControl() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCooledAirTemperature() {
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredOutdoorAirTemperature() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAutomaticControlOfAirFlowDirectionSetting() {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAutomaticSwingOfAirFlowSetting() {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAirFlowDirectionVerticalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAirFlowDirectionHorizontalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}
		@Override
		public Getter reqGetNonPriorityState() {
			addProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		@Override
		public Getter reqGetVentilationFunctionSetting() {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHumidifierFunctionSetting() {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetDegreeOfHumidificationSetting() {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMountedAirCleaningMethod() {
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		@Override
		public Getter reqGetAirPurifierFunctionSetting() {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMountedAirRefreshMethod() {
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		@Override
		public Getter reqGetAirRefresherFunctionSetting() {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMountedSelfCleaningMethod() {
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		@Override
		public Getter reqGetSelfCleaningFunctionSetting() {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSpecialFunctionSetting() {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOperationStatusOfComponents() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		@Override
		public Getter reqGetAirPurificationModeSetting() {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		@Override
		public Getter reqGetOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}

	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInformPower();
		public Informer reqInformInstallationLocation();
		public Informer reqInformVersion();
		public Informer reqInformIdNumber();
		public Informer reqInformElectricityConsumption();
		public Informer reqInformPowerConsumption();
		public Informer reqInformMakerErrorCode();
		public Informer reqInformCurrentLimiting();
		public Informer reqInformError();
		public Informer reqInformErrorInfo();
		public Informer reqInformMakerCode();
		public Informer reqInformWorkplaceCode();
		public Informer reqInformProductCode();
		public Informer reqInformManufacturingNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformPowerSaving();
		public Informer reqInformLocation();
		public Informer reqInformCurrentTime();
		public Informer reqInformCurrentDate();
		public Informer reqInformPowerLimitation();
		public Informer reqInformWorkingTime();
		public Informer reqInformAnnoPropertyMap();
		public Informer reqInformSetPropertyMap();
		public Informer reqInformGetPropertyMap();
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h �gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h), and to acquire the current setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>Automatic = 0x41 Non-automatic = 0x42
		 */
		public Informer reqInformAutomaticTemperatureControlSetting();
		/**
		 * Used to specify the type of operation (�gnormal,�h �ghigh-speed�h or �gsilent�h), and to acquire the current setting.<br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43
		 */
		public Informer reqInformNormalHighSpeedSilentOperationSetting();
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Informer reqInformSetTemperatureValue();
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode();
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Informer reqInformSetTemperatureValueInCoolingMode();
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Informer reqInformSetTemperatureValueInHeatingMode();
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��)
		 */
		public Informer reqInformSetTemperatureValueInDehumidifyingMode();
		/**
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast
		 */
		public Informer reqInformRatedPowerConsumption();
		/**
		 * Measured value of current consumption<br>0x0000.0xFFFD (0.6553.3A)
		 */
		public Informer reqInformMeasuredValueOfCurrentConsumption();
		/**
		 * Measured value of room relative humidity<br>0x00.0x64 (0.100. C)
		 */
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity();
		/**
		 * Measured value of room temperature<br>0x80.0x7D (-127.125.C)
		 */
		public Informer reqInformMeasuredValueOfRoomTemperature();
		/**
		 * Set temperature value of user remote control<br>0x00.0x32 (0.50.C)
		 */
		public Informer reqInformSetTemperatureValueOfUserRemoteControl();
		/**
		 * This property indicates the measured cooled air temperature at the outlet.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		public Informer reqInformMeasuredCooledAirTemperature();
		/**
		 * This property indicates the measured outdoor air temperature.<br>0x81 to 0x7D (-127 to 125��C)
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature();
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)
		 */
		public Informer reqInformRelativeTemperatureSetting();
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44
		 */
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting();
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43
		 */
		public Informer reqInformAutomaticSwingOfAirFlowSetting();
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45
		 */
		public Informer reqInformAirFlowDirectionVerticalSetting();
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.
		 */
		public Informer reqInformAirFlowDirectionHorizontalSetting();
		/**
		 * This property indicates if the air conditioner is in a �gspecial�h state (i.e. the �gdefrosting,�h �gpreheating,�h or �gheat removal�h state).<br>�gNormal operation�h state = 0x40, �gDefrosting�h state = 0x41, �gPreheating�h state = 0x42, �gHeat removal�h state = 0x43
		 */
		public Informer reqInformSpecialState();
		/**
		 * Used to indicate when the air conditioner is in a �gnon-priority�h state.<br>�gNormal operation�h state = 0x40, �gNon-priority�h state = 0x41
		 */
		public Informer reqInformNonPriorityState();
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43
		 */
		public Informer reqInformVentilationFunctionSetting();
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42
		 */
		public Informer reqInformHumidifierFunctionSetting();
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38
		 */
		public Informer reqInformVentilationAirFlowRateSetting();
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38
		 */
		public Informer reqInformDegreeOfHumidificationSetting();
		/**
		 * A bitmap indicates mounted method of exercising air cleaning function.<br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
		 */
		public Informer reqInformMountedAirCleaningMethod();
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.
		 */
		public Informer reqInformAirPurifierFunctionSetting();
		/**
		 * A bitmap indicates mounted method for exercising refresh function.<br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted
		 */
		public Informer reqInformMountedAirRefreshMethod();
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.
		 */
		public Informer reqInformAirRefresherFunctionSetting();
		/**
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted
		 */
		public Informer reqInformMountedSelfCleaningMethod();
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.
		 */
		public Informer reqInformSelfCleaningFunctionSetting();
		/**
		 * Used to specify the �gspecial function�h to use, and to acquire the current setting.<br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.
		 */
		public Informer reqInformSpecialFunctionSetting();
		/**
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.
		 */
		public Informer reqInformOperationStatusOfComponents();
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting.�B<br>Air purification ON��0x41,OFF�� 0x42
		 */
		public Informer reqInformAirPurificationModeSetting();
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		public Informer reqInformOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44
		 */
		public Informer reqInformOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)
		 */
		public Informer reqInformOffTimerSettingRelativeTime();

	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			return (Informer)super.reqInformSetPropertyMap();
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			return (Informer)super.reqInformGetPropertyMap();
		}

		@Override
		public Informer reqInformOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			byte[] edt = getAutomaticTemperatureControlSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNormalHighSpeedSilentOperationSetting() {
			byte[] edt = getNormalHighSpeedSilentOperationSetting();
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValue() {
			byte[] edt = getSetTemperatureValue();
			addProperty(EPC_SET_TEMPERATURE_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode() {
			byte[] edt = getSetValueOfRelativeHumidityInDehumidifyingMode();
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInCoolingMode() {
			byte[] edt = getSetTemperatureValueInCoolingMode();
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInHeatingMode() {
			byte[] edt = getSetTemperatureValueInHeatingMode();
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInDehumidifyingMode() {
			byte[] edt = getSetTemperatureValueInDehumidifyingMode();
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			byte[] edt = getRatedPowerConsumption();
			addProperty(EPC_RATED_POWER_CONSUMPTION, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCurrentConsumption() {
			byte[] edt = getMeasuredValueOfCurrentConsumption();
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			byte[] edt = getMeasuredValueOfRoomRelativeHumidity();
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomTemperature() {
			byte[] edt = getMeasuredValueOfRoomTemperature();
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueOfUserRemoteControl() {
			byte[] edt = getSetTemperatureValueOfUserRemoteControl();
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCooledAirTemperature() {
			byte[] edt = getMeasuredCooledAirTemperature();
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature() {
			byte[] edt = getMeasuredOutdoorAirTemperature();
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTemperatureSetting() {
			byte[] edt = getRelativeTemperatureSetting();
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			byte[] edt = getAirFlowRateSetting();
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting() {
			byte[] edt = getAutomaticControlOfAirFlowDirectionSetting();
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticSwingOfAirFlowSetting() {
			byte[] edt = getAutomaticSwingOfAirFlowSetting();
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			byte[] edt = getAirFlowDirectionVerticalSetting();
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			byte[] edt = getAirFlowDirectionHorizontalSetting();
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSpecialState() {
			byte[] edt = getSpecialState();
			addProperty(EPC_SPECIAL_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNonPriorityState() {
			byte[] edt = getNonPriorityState();
			addProperty(EPC_NON_PRIORITY_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationFunctionSetting() {
			byte[] edt = getVentilationFunctionSetting();
			addProperty(EPC_VENTILATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumidifierFunctionSetting() {
			byte[] edt = getHumidifierFunctionSetting();
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			byte[] edt = getVentilationAirFlowRateSetting();
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDegreeOfHumidificationSetting() {
			byte[] edt = getDegreeOfHumidificationSetting();
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMountedAirCleaningMethod() {
			byte[] edt = getMountedAirCleaningMethod();
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirPurifierFunctionSetting() {
			byte[] edt = getAirPurifierFunctionSetting();
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMountedAirRefreshMethod() {
			byte[] edt = getMountedAirRefreshMethod();
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirRefresherFunctionSetting() {
			byte[] edt = getAirRefresherFunctionSetting();
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMountedSelfCleaningMethod() {
			byte[] edt = getMountedSelfCleaningMethod();
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSelfCleaningFunctionSetting() {
			byte[] edt = getSelfCleaningFunctionSetting();
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSpecialFunctionSetting() {
			byte[] edt = getSpecialFunctionSetting();
			addProperty(EPC_SPECIAL_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfComponents() {
			byte[] edt = getOperationStatusOfComponents();
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirPurificationModeSetting() {
			byte[] edt = getAirPurificationModeSetting();
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			byte[] edt = getOnTimerBasedReservationSetting();
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			byte[] edt = getOnTimerSettingTime();
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			byte[] edt = getOnTimerSettingRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerBasedReservationSetting() {
			byte[] edt = getOffTimerBasedReservationSetting();
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			byte[] edt = getOffTimerSettingRelativeTime();
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}

	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
		}

		@Override
		public Informer reqInformSetPropertyMap() {
			return (Informer)super.reqInformSetPropertyMap();
		}

		@Override
		public Informer reqInformGetPropertyMap() {
			return (Informer)super.reqInformGetPropertyMap();
		}

		@Override
		public Informer reqInformOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformNormalHighSpeedSilentOperationSetting() {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValue() {
			addProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode() {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInCoolingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInHeatingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInDehumidifyingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCurrentConsumption() {
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomTemperature() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueOfUserRemoteControl() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCooledAirTemperature() {
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting() {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticSwingOfAirFlowSetting() {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}
		@Override
		public Informer reqInformNonPriorityState() {
			addProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		@Override
		public Informer reqInformVentilationFunctionSetting() {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHumidifierFunctionSetting() {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDegreeOfHumidificationSetting() {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMountedAirCleaningMethod() {
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		@Override
		public Informer reqInformAirPurifierFunctionSetting() {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMountedAirRefreshMethod() {
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		@Override
		public Informer reqInformAirRefresherFunctionSetting() {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMountedSelfCleaningMethod() {
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		@Override
		public Informer reqInformSelfCleaningFunctionSetting() {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSpecialFunctionSetting() {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfComponents() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		@Override
		public Informer reqInformAirPurificationModeSetting() {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}

	}
}
