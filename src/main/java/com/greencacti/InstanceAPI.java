package com.greencacti;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Created by baominw on 4/7/17.
 */
public class InstanceAPI {
    public static void main(String[] args) throws Exception{
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIbCevn9IEeRPy", "ut953MfoS9hLMsbUC3JPInZhdyRWOG");
        IAcsClient client = new DefaultAcsClient(profile);

        //String instanceId = createInstance(client);
        //startInstance(client, "i-bp1h8nr0sr6y3a3nl62h");
        //stopInstance(client, "i-bp1h8nr0sr6y3a3nl62h");
        deleteInstance(client, "i-bp1h8nr0sr6y3a3nl62h");
    }

    private static String createInstance(IAcsClient client) {
        CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest();
        createInstanceRequest.setImageId("ubuntu1404_64_40G_aliaegis_20160222.vhd");
        createInstanceRequest.setInstanceType("ecs.n1.small");
        //createInstanceRequest.setSecurityGroupId("sg-23jzh8f9y");
        createInstanceRequest.setInstanceName("VM1");
        createInstanceRequest.setInternetChargeType("PayByTraffic");
        createInstanceRequest.setInternetMaxBandwidthIn(1);
        createInstanceRequest.setInternetMaxBandwidthOut(1);
        createInstanceRequest.setIoOptimized("optimized");
        createInstanceRequest.setSystemDiskCategory("cloud_efficiency");
        createInstanceRequest.setPassword("Hello001");

        try {
            CreateInstanceResponse createInstanceResponse
                    = client.getAcsResponse(createInstanceRequest);
            System.out.print(createInstanceResponse.getInstanceId());
            return createInstanceResponse.getInstanceId();
        }
        catch (ClientException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void startInstance(IAcsClient client, String instanceId) throws Exception {
        StartInstanceRequest startInstanceRequest = new StartInstanceRequest();
        startInstanceRequest.setInstanceId(instanceId);
        client.getAcsResponse(startInstanceRequest);
    }

    private static void stopInstance(IAcsClient client, String instanceId) throws Exception {
        StopInstanceRequest stopInstanceRequest = new StopInstanceRequest();
        stopInstanceRequest.setInstanceId(instanceId);
        client.getAcsResponse(stopInstanceRequest);
    }

    private static void deleteInstance(IAcsClient client, String instanceId) throws Exception {
        DeleteInstanceRequest deleteInstanceRequest = new DeleteInstanceRequest();
        deleteInstanceRequest.setInstanceId(instanceId);
        client.getAcsResponse(deleteInstanceRequest);
    }
}
