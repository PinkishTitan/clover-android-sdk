package com.clover.sdk.v1.printer.job;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.clover.sdk.v1.printer.Category;
import com.clover.sdk.v3.order.Order;

import java.util.ArrayList;

public class StaticOrderPrintJob extends StaticOrderBasedPrintJob implements Parcelable {
  private static final String BUNDLE_KEY_ITEM_IDS = "i";
  private static final String BUNDLE_REPRINT_ALLOWED = "b";
  private static final String BUNDLE_KEY_MARK_PRINTED = "m";

  public static class Builder extends StaticOrderBasedPrintJob.Builder {
    protected ArrayList<String> itemIds;
    private boolean reprintAllowed = false;
    private boolean markPrinted = false;

    public Builder staticOrderPrintJob(StaticOrderPrintJob pj) {
      this.order = pj.order;
      this.itemIds = pj.itemIds;
      this.reprintAllowed = pj.reprintAllowed;
      this.flags = pj.flags;
      this.markPrinted = pj.markPrinted;

      return this;
    }

    public Builder itemIds(ArrayList<String> itemIds) {
      this.itemIds = itemIds;
      return this;
    }

    public Builder reprintAllowed(boolean allowed) {
      this.reprintAllowed = allowed;
      return this;
    }

    public Builder markPrinted(boolean markPrinted) {
      this.markPrinted = markPrinted;
      return this;
    }

    public StaticOrderPrintJob build() {
      return new StaticOrderPrintJob(order, itemIds, reprintAllowed, flags, markPrinted);
    }
  }

  public final ArrayList<String> itemIds;
  public final boolean reprintAllowed;
  public final boolean markPrinted;

  public StaticOrderPrintJob(Order order, ArrayList<String> itemIds, boolean reprintAllowed, int flags, boolean markPrinted) {
    super(order, flags);
    this.itemIds = itemIds;
    this.reprintAllowed = reprintAllowed;
    this.markPrinted = markPrinted;
  }

  public static final Creator<StaticOrderPrintJob> CREATOR = new Creator<StaticOrderPrintJob>() {
    public StaticOrderPrintJob createFromParcel(Parcel in) {
      return new StaticOrderPrintJob(in);
    }

    public StaticOrderPrintJob[] newArray(int size) {
      return new StaticOrderPrintJob[size];
    }
  };

  protected StaticOrderPrintJob(Parcel in) {
    super(in);
    Bundle bundle = in.readBundle(getClass().getClassLoader()); // needed otherwise BadParcelableException: ClassNotFoundException when unmarshalling
    itemIds = bundle.getStringArrayList(BUNDLE_KEY_ITEM_IDS);
    reprintAllowed = bundle.getBoolean(BUNDLE_REPRINT_ALLOWED);
    markPrinted = bundle.getBoolean(BUNDLE_KEY_MARK_PRINTED);
  }

  @Override
  public Category getPrinterCategory() {
    return Category.ORDER;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    Bundle bundle = new Bundle();
    bundle.putStringArrayList(BUNDLE_KEY_ITEM_IDS, itemIds);
    bundle.putBoolean(BUNDLE_REPRINT_ALLOWED, reprintAllowed);
    bundle.putBoolean(BUNDLE_KEY_MARK_PRINTED, markPrinted);

    dest.writeBundle(bundle);
  }
}
