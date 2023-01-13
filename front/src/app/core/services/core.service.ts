import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { baseUrl } from 'src/environments/environment';
import { Post } from '../interfaces/post';

@Injectable({
  providedIn: 'root',
})
export class CoreService {
  constructor(private http: HttpClient) {}

  public getAuthHeaders() {
    return new HttpHeaders().set(
      'Authorization',
      'Bearer ' + localStorage.getItem('token')
    );
  }

  createPost(body: Post): Observable<any> {
    return this.http.post(
      `${baseUrl}/post/${localStorage.getItem('id')}`,
      body,
      {
        headers: this.getAuthHeaders(),
      }
    );
  }

  getAllPost(params: any): Observable<any> {
    return this.http.get(
      `${baseUrl}/posts?page=${params.page}&limit=${params.limit}`,
      { headers: this.getAuthHeaders() }
    );
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/posts/${id}`, {
      headers: this.getAuthHeaders(),
    });
  }
}
