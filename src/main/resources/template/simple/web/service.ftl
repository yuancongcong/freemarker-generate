import axios from 'axios';


export const deleteByIds = params =>  axios.post('/${module_name}/${name}/deleteByIds', params)

export const save = params =>  axios.post('/${module_name}/${name}/save', params)

export const getById = id => axios.post('/${module_name}/${name}/get',{id} )

export const getListPage = params =>  axios.post('/${module_name}/${name}/listPage', params)
