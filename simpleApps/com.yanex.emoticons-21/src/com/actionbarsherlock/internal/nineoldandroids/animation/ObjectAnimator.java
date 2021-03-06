package com.actionbarsherlock.internal.nineoldandroids.animation;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private String mPropertyName;
    private Object mTarget;

    private ObjectAnimator(Object obj, String str) {
        this.mTarget = obj;
        setPropertyName(str);
    }

    public static ObjectAnimator ofFloat(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.mTarget = obj;
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    final void animateValue(float f) {
        super.animateValue(f);
        int length = this.mValues.length;
        int i = 0;
        while (i < length) {
            this.mValues[i].setAnimatedValue(this.mTarget);
            i++;
        }
    }

    public final ObjectAnimator clone() {
        return (ObjectAnimator) super.clone();
    }

    public final String getPropertyName() {
        return this.mPropertyName;
    }

    public final Object getTarget() {
        return this.mTarget;
    }

    final void initAnimation() {
        if (!this.mInitialized) {
            int length = this.mValues.length;
            int i = 0;
            while (i < length) {
                this.mValues[i].setupSetterAndGetter(this.mTarget);
                i++;
            }
            super.initAnimation();
        }
    }

    public final ObjectAnimator setDuration(long j) {
        super.setDuration(j);
        return this;
    }

    public final void setFloatValues(float... fArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.mPropertyName, fArr)});
        } else {
            super.setFloatValues(fArr);
        }
    }

    public final void setIntValues(int... iArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofInt(this.mPropertyName, iArr)});
        } else {
            super.setIntValues(iArr);
        }
    }

    public final void setObjectValues(Object... objArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(this.mPropertyName, null, objArr)});
        } else {
            super.setObjectValues(objArr);
        }
    }

    public final void setPropertyName(String str) {
        if (this.mValues != null) {
            PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(str, propertyValuesHolder);
        }
        this.mPropertyName = str;
        this.mInitialized = false;
    }

    public final void setTarget(Object obj) {
        if (this.mTarget != obj) {
            Object obj2 = this.mTarget;
            this.mTarget = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.mInitialized = false;
            }
        }
    }

    public final void setupEndValues() {
        initAnimation();
        int length = this.mValues.length;
        int i = 0;
        while (i < length) {
            this.mValues[i].setupEndValue(this.mTarget);
            i++;
        }
    }

    public final void setupStartValues() {
        initAnimation();
        int length = this.mValues.length;
        int i = 0;
        while (i < length) {
            this.mValues[i].setupStartValue(this.mTarget);
            i++;
        }
    }

    public final void start() {
        super.start();
    }

    public final String toString() {
        String toString = new StringBuilder("ObjectAnimator@").append(Integer.toHexString(hashCode())).append(", target ").append(this.mTarget).toString();
        if (this.mValues != null) {
            int i = 0;
            while (i < this.mValues.length) {
                toString = toString + "\n    " + this.mValues[i].toString();
                i++;
            }
        }
        return toString;
    }
}