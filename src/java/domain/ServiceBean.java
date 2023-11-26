/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import services.ServiceService;

/**
 *
 * @author akhmim
 */
//@ManagedBean(name = "serviceBean")
@ManagedBean
@SessionScoped
public class ServiceBean {

    private Service service;
    private List<Service> services;
    private ServiceService serviceService;

    /**
     * Creates a new instance of ServiceBean
     */
    public ServiceBean() {
        services = new ArrayList<>();
        service = new Service();
        serviceService = new ServiceService();

    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public String onCreateAction() {
        System.out.println(service.getCode());
        System.out.println(service.getLibelle());
        services.add(service);
        serviceService.create(service);
        System.out.println(services);  
        service = new Service();
        return null;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

//    public List<Service> serviceLoad() {
//        for (Service s : serviceService.getAll()) {
//            if (s.getCode().equals(service)) {
//                services.add(s);
//            }
//        }
//        return services;
//
//    }
    public void load() {
        System.out.println(service.getLibelle());
        service = serviceService.getById(service.getId());
        getServices();
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getServices() {
        if (services == null) {
            services = serviceService.getAll();
        }
        return services;
    }
}
