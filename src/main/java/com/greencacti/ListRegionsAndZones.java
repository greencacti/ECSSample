package com.greencacti;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.*;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Created by baominw on 4/7/17.
 */
public class ListRegionsAndZones {
    public static void main(String[] args) throws Exception{
        IClientProfile profile  = DefaultProfile.getProfile("cn-hangzhou", "LTAIbCevn9IEeRPy", "ut953MfoS9hLMsbUC3JPInZhdyRWOG");
        IAcsClient client = new DefaultAcsClient(profile);

        DescribeRegionsRequest describeRegionsRequest = new DescribeRegionsRequest();
        DescribeRegionsResponse describeRegionsResponse = client.getAcsResponse(describeRegionsRequest);
        for(DescribeRegionsResponse.Region region: describeRegionsResponse.getRegions()) {
            System.out.println(region.getRegionId());
            System.out.println(region.getLocalName());
            System.out.println();

            DescribeZonesRequest describeZonesRequest = new DescribeZonesRequest();
            describeZonesRequest.setRegionId(region.getRegionId());
            DescribeZonesResponse describeZonesResponse = client.getAcsResponse(describeZonesRequest);
            for(DescribeZonesResponse.Zone zone: describeZonesResponse.getZones()) {
                System.out.println(zone.getZoneId());
                System.out.println(zone.getLocalName());
            }
        }
    }
}
