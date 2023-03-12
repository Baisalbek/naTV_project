package kg.mega.naTV.entities.dto.response;

import lombok.Data;

@Data
public class DiscountGetDto {  //DTO для для получения списка скидок в определенном канале, без лишней информации
    private Long fromDayCount;
    private Long discount;
}
