package com.ch.zhihuxiangmu.ui.zhihu.contract.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.LunBo;

import java.util.List;

/**
 * Created by 123 on 2017/1/6.
 */
public class LunBaoUtil {

    public  void urlTupian(ConvenientBanner con, List<LunBo.TopStoriesBean> list) {
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        con.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                },list)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }
    public class LocalImageHolderView implements Holder<LunBo.TopStoriesBean> {
        private View view;
        private ImageView im;
        private TextView te;
        @Override
        public View createView(Context context) {
            view = View.inflate(context, R.layout.lunbo,null);
            im = (ImageView) view.findViewById(R.id.lunbo_image);
            te = (TextView) view.findViewById(R.id.lunbo_text);
            return view;
        }

        @Override
        public void UpdateUI(Context context, int position, LunBo.TopStoriesBean data) {
            //list.clear();
            //im.setImageResource(R.mipmap.ic_launcher);
            //ImageLoader.getInstance().displayImage(data.getImage(),im);
            Glide.with(context)
                    .load(data.getImage())
                    .into(im);
            te.setText(data.getTitle());
        }

    }
}
