package uz.qodirov.mapper;

public interface BaseMapper<E, CD> extends Mapper {
    E fromCreateDto(CD dto);
}
