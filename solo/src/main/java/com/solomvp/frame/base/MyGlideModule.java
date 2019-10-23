package com.solomvp.frame.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by chenshaolong on 2018/11/18.
 */

@GlideModule
public class MyGlideModule extends AppGlideModule {

    private static final String TAG = MyGlideModule.class.getSimpleName();

    @Override
    public void applyOptions(final Context context, @NonNull GlideBuilder builder) {
//        Log.i(TAG, "applyOptions");
//        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
//        int maxMemory = (int) Runtime.getRuntime().maxMemory();//获取系统分配给应用的总内存大小
//        int memoryCacheSize = maxMemory / 8;//设置图片内存缓存占用八分之一
//
//        if (memoryCacheSize < 5120) {
//            memoryCacheSize = 5120;
//        }
//
//        MemorySizeCalculator.Builder calculatorBuilder = new MemorySizeCalculator.Builder(context);
//
//        MemorySizeCalculator calculator = calculatorBuilder.build();
//        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
//        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
//
//        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
//        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
//        Log.i(TAG, "defaultMemoryCacheSize:" + defaultMemoryCacheSize + "defaultBitmapPoolSize" + defaultBitmapPoolSize);
//        Log.i(TAG, "customMemoryCacheSize:" + customMemoryCacheSize + "customBitmapPoolSize" + customBitmapPoolSize);
////        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
//        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));
//
//        builder.setDiskCache(new DiskCache.Factory() {
//            @Override
//            public DiskCache build() {
////                File cacheLocation = new File(FSDirManager.instance().getPath(FSDirManager.WorkDir.CACHE_IMG));
//                File cacheLocation = context.getCacheDir();
//                return DiskLruCacheWrapper.get(cacheLocation, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
//            }
//        });
//        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {

    }
}
