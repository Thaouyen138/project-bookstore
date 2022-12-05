import {Category} from './category';

export interface Book{
  id?: number;
  name?: string;
  totalPage?: string;
  publisher?: string;
  publishedDate?: string;
  authors?: string;
  category?: Category;
  url?: string;
  price?: string;
}
