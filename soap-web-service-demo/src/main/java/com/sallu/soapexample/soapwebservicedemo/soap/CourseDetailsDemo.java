package com.sallu.soapexample.soapwebservicedemo.soap;

import com.salluworld.CourseDetails;
import com.salluworld.GetCourseDetailsRequest;
import com.salluworld.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsDemo {

    @PayloadRoot(namespace = "http://salluworld.com", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse getCourseDetailsResponse(@RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Java Spring boot");
        courseDetails.setDescription("A comprehensive java course");

        response.setCourseDetails(courseDetails);
        return response;
    }
}
