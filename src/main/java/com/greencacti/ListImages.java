package com.greencacti;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeImagesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeImagesResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


/**
 * Created by baominw on 4/7/17.
 */
public class ListImages {
    public static void main(String[] args) throws Exception{
        IClientProfile profile  = DefaultProfile.getProfile("cn-hangzhou", "LTAIbCevn9IEeRPy", "ut953MfoS9hLMsbUC3JPInZhdyRWOG");
        IAcsClient client = new DefaultAcsClient(profile);

        DescribeImagesRequest describe = new DescribeImagesRequest();
        describe.setImageOwnerAlias("system");
        DescribeImagesResponse response = client.getAcsResponse(describe);
        for(DescribeImagesResponse.Image image:response.getImages()){
            System.out.println(image.getImageId());
            System.out.println(image.getImageName());
        }
    }
}
