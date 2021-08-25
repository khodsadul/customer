package com.tagmeds.customer.mapper;

import java.util.Collection;
import java.util.List;

public interface GenericMapper<Entity, Dto> {

	public Dto entityToDto(Entity entity);

	public Entity dtoToEntity(Dto dto);

	public List<Entity> dtoListToEntityList(List<Dto> dtos);

	public List<Dto> entityListToDtoList(List<Entity> entities);

	public Collection<Dto> entityCollectionToDtoCollection(Collection<Entity> entities);

	public List<Dto> entityCollectionToDtoList(Collection<Entity> entities);

}
