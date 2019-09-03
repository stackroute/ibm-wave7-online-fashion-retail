import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Product} from '../classes/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(private httpClient: HttpClient) {
  }

  public getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8080/api/v1/product', {headers: this.headers});
  }

  public tracksExists(track: Product) {
    return this.httpClient.post('http://localhost:8080/api/v1/track/find', track, {headers: this.headers});
  }

  // public searchTracks(searchItem): Observable<Product[]> {
  //   return this.httpClient.get<Product[]>(this.searchurl.replace('track_to_search', searchItem)).pipe(
  //     map(response => {
  //       const result = 'results';
  //       const trackMatches = 'trackmatches';
  //       const track = 'track';
  //       const artist = 'artist';
  //       const name = 'name';
  //       const arr: Product[] = [];
  //       console.log(this.searchurl.replace('track_to_search', searchItem));
  //       console.log(response);
  //       for (const trackItem of response[result][trackMatches][track]) {
  //         arr.push(new Product(trackItem[name], trackItem[artist], '', ''));
  //       }
  //       return arr;
  //     }));
  // }

  public addTrack(track: Product) {
    console.log(track);
    return this.httpClient.post('http://localhost:8080/api/v1/track', track, {headers: this.headers});
    // .pipe(
    //   catchError(this.handleError('addHero', hero))
    // );
  }

  public deleteTrack(track: Product): Observable<{}> {
    return this.httpClient.request('delete', 'http://localhost:8080/api/v1/track/', {body: track, headers: this.headers});
    // .pipe(
    //   catchError(this.handleError('deleteHero'))
    // );
  }

  public updateTrack(track: Product): Observable<Product> {
    return this.httpClient.put<Product>('http://localhost:8080/api/v1/track/', track, {headers: this.headers});
  }

  public getTopTracks(): Observable<Product[]> {


    return this.httpClient.get('http://localhost:8080/api/v1/track/').pipe(
      map(response => {

        // console.log('hel');
        const trackKey = 'tracks';
        const tracksKey = 'track';
        const artist = 'artist';
        const name = 'name';
        const arr: Product[] = [];
        for (const track of response[trackKey][tracksKey]) {
          const image = '';
          // arr.push(new Product(track[name], track[artist][name], '', image));
        }
        return arr;
      }));
  }
}
