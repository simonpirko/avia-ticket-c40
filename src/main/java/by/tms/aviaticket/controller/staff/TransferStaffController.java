package by.tms.aviaticket.controller.staff;

import by.tms.aviaticket.entity.Transfer;
import by.tms.aviaticket.entity.dto.TransferCreateDto;
import by.tms.aviaticket.service.exception.AirplaneNotFoundException;
import by.tms.aviaticket.service.exception.TransferNotFoundException;
import by.tms.aviaticket.service.staff.AirplaneStaffService;
import by.tms.aviaticket.service.staff.TransferStaffService;
import by.tms.aviaticket.util.MappingUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
@RequestMapping("/staff/transfer")
public class TransferStaffController {
    private final TransferStaffService transferStaffService;
    private final AirplaneStaffService airplaneStaffService;
    private final MappingUtils mappingUtils;

    public TransferStaffController(TransferStaffService transferStaffService, AirplaneStaffService airplaneStaffService, MappingUtils mappingUtils) {
        this.transferStaffService = transferStaffService;
        this.airplaneStaffService = airplaneStaffService;
        this.mappingUtils = mappingUtils;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("list", transferStaffService.getAll());
        return "staff/getTransfer";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("airplaneList", airplaneStaffService.getAll());
        model.addAttribute("transfer", new TransferCreateDto());
        return "staff/createTransfer";
    }

    @PostMapping("/create")
    public String createHandler(
            @ModelAttribute("transfer") @Valid TransferCreateDto transferCreateDto,
            BindingResult bindingResult,
            Model model
    ) {

        if(!bindingResult.hasErrors()) {
            try {
                Transfer transfer = mappingUtils.mapToTransferEntity(transferCreateDto);
                transferStaffService.create(transfer);
                model.addAttribute("message", "Трансфер успешно создан");
            } catch (AirplaneNotFoundException e) {
                model.addAttribute("message", "Самалет указан не корректно");
            }
        }

        model.addAttribute("airplaneList", airplaneStaffService.getAll());
        return "staff/createTransfer";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable @Min(1) long id, Model model){
        try {
            Transfer transfer = transferStaffService.get(id);
            model.addAttribute("transfer", mappingUtils.mapToCreateTransferDto(transfer));
            model.addAttribute("airplaneList", airplaneStaffService.getAll());
            return "staff/updateTransfer";
        } catch (TransferNotFoundException e) {
            model.addAttribute("message", "Трансфер не найден");
            return "redirect:/staff/transfer";
        }
    }
    @PostMapping("/update/{id}")
    public String updateHandler(
            @ModelAttribute("transfer") @Valid TransferCreateDto transferCreateDto,
            BindingResult bindingResult,
            @PathVariable @Min(1) long id,
            Model model
    ){
        if(!bindingResult.hasErrors()) {
            try {
                Transfer transfer = mappingUtils.mapToTransferEntity(transferCreateDto);
                transferStaffService.update(id, transfer);
                model.addAttribute("message", "Трансфер успешно обновлен");
            } catch (TransferNotFoundException e) {
                model.addAttribute("message", "Трансфер не найден");
                return "redirect:/staff/transfer";
            } catch (AirplaneNotFoundException e) {
                model.addAttribute("message", "Самалет указан не корректно");
            }
        }
        model.addAttribute("airplaneList", airplaneStaffService.getAll());
        return "staff/updateTransfer";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable @Min(1) long id, Model model) {
        try {
            transferStaffService.delete(id);
            model.addAttribute("message", "Трансфер успешно удален");
        } catch (TransferNotFoundException e) {
            model.addAttribute("message", "Трансфер не найден");
        }
        return "redirect:/staff/transfer";
    }
}
