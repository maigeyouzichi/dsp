package com.lz.matcher;

public class DefaultNumberCompare<T extends Number> implements Compare<T>{
        private final boolean great;

        public DefaultNumberCompare(boolean great) {
            this.great = great;
        }

        @Override
        public boolean compare(Number operand, Number actual) {
            Class<?> clazz = actual.getClass();
            if (clazz == Integer.class) {
                return great ? (Integer) actual > (Integer) operand : (Integer) actual < (Integer) operand;
            } else if (clazz == Byte.class) {
                return great ? (Byte) actual > (Byte) operand : (Byte) actual < (Byte) operand;
            } else if (clazz == Short.class) {
                return great ? (Short) actual > (Short) operand : (Short) actual < (Short) operand;
            } else if (clazz == Long.class) {
                return great ? (Long) actual > (Long) operand : (Long) actual < (Long) operand;
            } else if (clazz == Float.class) {
                return great ? (Float) actual > (Float) operand : (Float) actual < (Float) operand;
            } else if (clazz == Double.class) {
                return great ? (Double) actual > (Double) operand : (Double) actual < (Double) operand;
            }else {
                return false;
            }
        }
    }