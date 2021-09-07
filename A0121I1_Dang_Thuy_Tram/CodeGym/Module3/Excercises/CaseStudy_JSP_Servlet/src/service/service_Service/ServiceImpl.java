package service.service_Service;


import dao.serviceDAO.IServiceDAO;
import dao.serviceDAO.ServiceDAO;
import service.serviceTypeRent_Service.IRent_Type;
import service.serviceTypeRent_Service.Rent_TypeImpl;
import service.serviceType_Service.IService_Type;
import service.serviceType_Service.Service_Type;

import java.sql.SQLException;
import java.util.List;

public class Service implements IService {
    private IServiceDAO serviceDAO = new ServiceDAO();
    private IService_Type serviceType = new Service_Type();
    private IRent_Type serviceTypeRent = new Rent_TypeImpl();

    @Override
    public void saveService(model.service.Service service) throws SQLException {
        this.serviceDAO.saveService(service);
    }

    @Override
    public model.service.Service getServiceById(int id) throws SQLException {
        return this.serviceDAO.getServiceById(id);
    }

    @Override
    public List<model.service.Service> getAllService() throws SQLException {
        return this.serviceDAO.getAllService();
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return this.serviceDAO.deleteService(id);
    }

    @Override
    public boolean updateService(model.service.Service service, int id) throws SQLException {
        return this.serviceDAO.updateService(service);
    }

//    @Override
//    public List<ServiceDTO> getAllServiceDTO() throws SQLException {
//        List<ServiceDTO> serviceDTOList = new ArrayList<>();
//        List<SV_Service> serviceList = this.serviceDAO.getAllService();
//
//        for (SV_Service service : serviceList) {
//            ServiceDTO serviceDTO = new ServiceDTO();
//            serviceDTO.setId(service.getId());
//            serviceDTO.setName(service.getName());
//            serviceDTO.setStatus(service.getStatus());
//
//            SV_TypeService typeService = this.serviceType.getTypeServiceById(service.getIdTypeServices());
//            serviceDTO.setIdTypeService(typeService.getId());
//            serviceDTO.setNameTypeService(typeService.getName());
//
//            SV_TypeRent typeRent = this.serviceTypeRent.getTypeRentServiceById(service.getIdTypeRents());
//            serviceDTO.setIdTypeRent(typeRent.getId());
//            serviceDTO.setNameTypeRent(typeRent.getName());
//
//            serviceDTOList.add(serviceDTO);
//        }
//        return serviceDTOList;
//    }
}