/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */


/*
 * Copyright (C) 2013 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clover.sdk.v3.app;

@SuppressWarnings("all")
public final class Screenshot implements android.os.Parcelable, com.clover.sdk.v3.Validator, com.clover.sdk.JSONifiable {


  private enum CacheKey {
    name {
      @Override
      public Object extractValue(Screenshot instance) {
        return instance.extractName();
      }
    },
    small {
      @Override
      public Object extractValue(Screenshot instance) {
        return instance.extractSmall();
      }
    },
    large {
      @Override
      public Object extractValue(Screenshot instance) {
        return instance.extractLarge();
      }
    },
    ;

    public abstract Object extractValue(Screenshot instance);
  }

  private String jsonString = null;
  private org.json.JSONObject jsonObject = null;
  private android.os.Bundle bundle = null;
  private android.os.Bundle changeLog = null;
  private Object[] cache = null;
  private byte[] cacheState = null;

  private static final byte STATE_NOT_CACHED = 0;
  private static final byte STATE_CACHED_NO_VALUE = 1;
  private static final byte STATE_CACHED_VALUE = 2;

  /**
   * Constructs a new empty instance.
   */
  public Screenshot() { }

  /**
   * Constructs a new instance from the given JSON String.
   */
  public Screenshot(String json) {
    this.jsonString = json;
  }

  /**
   * Construct a new instance backed by the given JSONObject, the parameter is not copied so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public Screenshot(org.json.JSONObject jsonObject) {
    this.jsonObject = jsonObject;
  }

  /**
   * Constructs a new instance that is a deep copy of the source instance. It does not copy the bundle or changelog.
   */
  public Screenshot(Screenshot src) {
    if (src.jsonString != null) {
      this.jsonString = src.jsonString;
    } else {
      this.jsonObject = com.clover.sdk.v3.JsonHelper.deepCopy(src.getJSONObject());
    }
  }

  private <T> T cacheGet(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return (T) cache[index];
  }

  private boolean cacheValueIsNotNull(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return cache[index] != null;
  }

  private boolean cacheHasKey(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    return cacheState[index] == STATE_CACHED_VALUE;
  }

  private void cacheRemoveValue(CacheKey key) {
    int index = key.ordinal();
    populateCache(index);
    cache[index] = null;
    cacheState[index] = STATE_CACHED_NO_VALUE;
  }

  private void cacheMarkDirty(CacheKey key) {
    if (cache != null) {
      int index = key.ordinal();
      cache[index] = null;
      cacheState[index] = STATE_NOT_CACHED;
    }
  }

  private void populateCache(int index) {
    if (cache == null) {
      int size = CacheKey.values().length;
      cache = new Object[size];
      cacheState = new byte[size];
    }

    if (cacheState[index] == STATE_NOT_CACHED) {
      CacheKey key = CacheKey.values()[index];

      if (getJSONObject().has(key.name())) {
        cache[index] = key.extractValue(this);
        cacheState[index] = STATE_CACHED_VALUE;
      } else {
        cacheState[index] = STATE_CACHED_NO_VALUE;
      }
    }
  }

  /**
   * Returns the internal JSONObject backing this instance, the return value is not a copy so changes to it will be
   * reflected in this instance and vice-versa.
   */
  public org.json.JSONObject getJSONObject() {
    try {
      if (jsonObject == null) {
        if (jsonString != null) {
          jsonObject = new org.json.JSONObject(jsonString);
          jsonString = null; // null this so it will be recreated if jsonObject is modified
        } else {
          jsonObject = new org.json.JSONObject();
        }
      }
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }
    return jsonObject;
  }


  @Override
  public void validate() {
    java.lang.String name = getName();
    if (name != null && name.length() > 255) throw new IllegalArgumentException("Maximum string length exceeded for 'name'");

    java.lang.String small = getSmall();
    if (small != null && small.length() > 255) throw new IllegalArgumentException("Maximum string length exceeded for 'small'");

    java.lang.String large = getLarge();
    if (large != null && large.length() > 255) throw new IllegalArgumentException("Maximum string length exceeded for 'large'");
  }


  /**
   * URL for the app screenshot
   */
  public java.lang.String getName() {
    return cacheGet(CacheKey.name);
  }

  private java.lang.String extractName() {
    return getJSONObject().isNull("name") ? null :
      getJSONObject().optString("name");
  }

  /**
   * URL for the small version (80 x 80) of the app screenshot
   */
  public java.lang.String getSmall() {
    return cacheGet(CacheKey.small);
  }

  private java.lang.String extractSmall() {
    return getJSONObject().isNull("small") ? null :
      getJSONObject().optString("small");
  }

  /**
   * URL for the large version (800 x 800) of the app screenshot
   */
  public java.lang.String getLarge() {
    return cacheGet(CacheKey.large);
  }

  private java.lang.String extractLarge() {
    return getJSONObject().isNull("large") ? null :
      getJSONObject().optString("large");
  }


  /** Checks whether the 'name' field is set and is not null */
  public boolean isNotNullName() {
    return cacheValueIsNotNull(CacheKey.name);
  }

  /** Checks whether the 'small' field is set and is not null */
  public boolean isNotNullSmall() {
    return cacheValueIsNotNull(CacheKey.small);
  }

  /** Checks whether the 'large' field is set and is not null */
  public boolean isNotNullLarge() {
    return cacheValueIsNotNull(CacheKey.large);
  }


  /** Checks whether the 'name' field has been set, however the value could be null */
  public boolean hasName() {
    return cacheHasKey(CacheKey.name);
  }

  /** Checks whether the 'small' field has been set, however the value could be null */
  public boolean hasSmall() {
    return cacheHasKey(CacheKey.small);
  }

  /** Checks whether the 'large' field has been set, however the value could be null */
  public boolean hasLarge() {
    return cacheHasKey(CacheKey.large);
  }


  /**
   * Sets the field 'name'.
   */
  public Screenshot setName(java.lang.String name) {
    logChange("name");

    try {
      getJSONObject().put("name", name == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(name));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.name);
    return this;
  }

  /**
   * Sets the field 'small'.
   */
  public Screenshot setSmall(java.lang.String small) {
    logChange("small");

    try {
      getJSONObject().put("small", small == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(small));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.small);
    return this;
  }

  /**
   * Sets the field 'large'.
   */
  public Screenshot setLarge(java.lang.String large) {
    logChange("large");

    try {
      getJSONObject().put("large", large == null ? org.json.JSONObject.NULL : com.clover.sdk.v3.JsonHelper.toJSON(large));
    } catch (org.json.JSONException e) {
      throw new java.lang.IllegalArgumentException(e);
    }

    cacheMarkDirty(CacheKey.large);
    return this;
  }


  /** Clears the 'name' field, the 'has' method for this field will now return false */
  public void clearName() {
    unlogChange("name");
    getJSONObject().remove("name");
    cacheRemoveValue(CacheKey.name);
  }

  /** Clears the 'small' field, the 'has' method for this field will now return false */
  public void clearSmall() {
    unlogChange("small");
    getJSONObject().remove("small");
    cacheRemoveValue(CacheKey.small);
  }

  /** Clears the 'large' field, the 'has' method for this field will now return false */
  public void clearLarge() {
    unlogChange("large");
    getJSONObject().remove("large");
    cacheRemoveValue(CacheKey.large);
  }


  private void logChange(java.lang.String field) {
    if (changeLog == null) {
      changeLog = new android.os.Bundle();
    }
    changeLog.putString(field, null);
  }

  private void unlogChange(java.lang.String field) {
    if (changeLog != null) {
      changeLog.remove(field);
    }
  }

  /**
   * Returns true if this instance has any changes.
   */
  public boolean containsChanges() {
    return changeLog != null;
  }

  /**
   * Reset the log of changes made to this instance, calling copyChanges() after this would return an empty instance.
   */
  public void resetChangeLog() {
    changeLog = null;
  }

  /**
   * Create a copy of this instance that contains only fields that were set after the constructor was called.
   */
  public Screenshot copyChanges() {
    Screenshot copy = new Screenshot();
    copy.mergeChanges(this);
    copy.resetChangeLog();
    return copy;
  }

  /**
   * Copy all the changed fields from the given source to this instance.
   */
  public void mergeChanges(Screenshot src) {
    if (src.changeLog != null) {
      try {
        // Make a copy of the source so the destination fields are copies
        org.json.JSONObject srcObj = new Screenshot(src).getJSONObject();
        org.json.JSONObject dstObj = getJSONObject();
        for (java.lang.String field : src.changeLog.keySet()) {
          dstObj.put(field, srcObj.get(field));
          logChange(field);
        }
      } catch (org.json.JSONException e) {
        throw new java.lang.IllegalArgumentException(e);
      }
    }
  }


  /**
   * Gets a Bundle which can be used to get and set data attached to this instance. The attached Bundle will be
   * parcelled but not jsonified.
   */
  public android.os.Bundle getBundle() {
    if (bundle == null) {
      bundle = new android.os.Bundle();
    }
    return bundle;
  }

  @Override
  public String toString() {
    String json = jsonString != null ? jsonString : getJSONObject().toString();

    if (bundle != null) {
      bundle.isEmpty(); // Triggers unparcel
    }

    if (changeLog != null) {
      changeLog.isEmpty(); // Triggers unparcel
    }

    return "Screenshot{" +
        "json='" + json + "'" +
        ", bundle=" + bundle +
        ", changeLog=" + changeLog +
        '}';
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(android.os.Parcel dest, int flags) {
	  com.clover.sdk.v3.JsonParcelHelper.wrap(getJSONObject()).writeToParcel(dest, 0);
    dest.writeBundle(bundle);
    dest.writeBundle(changeLog);
  }

  public static final android.os.Parcelable.Creator<Screenshot> CREATOR = new android.os.Parcelable.Creator<Screenshot>() {
    @Override
    public Screenshot createFromParcel(android.os.Parcel in) {
      Screenshot instance = new Screenshot(com.clover.sdk.v3.JsonParcelHelper.ObjectWrapper.CREATOR.createFromParcel(in).unwrap());
      instance.bundle = in.readBundle();
      instance.changeLog = in.readBundle();
      return instance;
    }

    @Override
    public Screenshot[] newArray(int size) {
      return new Screenshot[size];
    }
  };

  public static final com.clover.sdk.JSONifiable.Creator<Screenshot> JSON_CREATOR = new com.clover.sdk.JSONifiable.Creator<Screenshot>() {
    @Override
    public Screenshot create(org.json.JSONObject jsonObject) {
      return new Screenshot(jsonObject);
    }
  };


  public interface Constraints {

    public static final boolean NAME_IS_REQUIRED = false;
    public static final long NAME_MAX_LEN = 255;

    public static final boolean SMALL_IS_REQUIRED = false;
    public static final long SMALL_MAX_LEN = 255;

    public static final boolean LARGE_IS_REQUIRED = false;
    public static final long LARGE_MAX_LEN = 255;

  }

}